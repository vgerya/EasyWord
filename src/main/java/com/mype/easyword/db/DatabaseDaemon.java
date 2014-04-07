package com.mype.easyword.db;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import com.googlecode.flyway.core.Flyway;
import org.hsqldb.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vitaliy Gerya
 */
public class DatabaseDaemon {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseDaemon.class);

    private static final String DB_ADDRESS = "127.0.0.1";
    private static final String DB_NAME = "vocabulary";
    private static final String DB_PATH = "db/vocabulary";
    private static final int DB_PORT = 9191;
    private Flyway migration = new Flyway();
    private Server server;

    @Inject
    private PersistService persistService;

    public DatabaseDaemon() {
        logger.info("Initializing migration service.");
        migration.setDataSource("jdbc:hsqldb:file:" + DB_PATH, "sa", "");
        migration.setSchemas(DB_NAME);
    }

    public void start() {
        if (server == null) {
            logger.info("Database starting...");
            server = new Server();
            server.setAddress(DB_ADDRESS);
            server.setPort(DB_PORT);
            server.setDatabaseName(0, DB_NAME);
            server.setDatabasePath(0, DB_PATH);
            server.start();
        }
        logger.info("Database started.");

        logger.info("Persistence service starting");
        persistService.start();
        logger.info("Persistence service started.");

        logger.info("Migration starting.");
        migration.migrate();
        logger.info("Migration started.");
    }

    public void stop() {
        logger.info("Stopping Persistence service.");
        persistService.stop();
        logger.info("Stopped Persistence service.");

        if (server != null) {
            logger.info("Stopping Database.");
            server.stop();
            server = null;
            logger.info("Stopped Database.");
        }
    }

}
