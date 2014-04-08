package com.mype.easyword.db;

import com.google.inject.Inject;
import com.google.inject.name.Named;
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

    private final Flyway migration = new Flyway();
    private Server server;

    @Inject
    @Named("db.name")
    private String dbName;

    @Inject
    @Named("db.address")
    private String dbAddress;

    @Inject
    @Named("db.port")
    private int dbPort;

    @Inject
    @Named("db.path")
    private String dbPath;

    @Inject
    @Named("db.datasource")
    private String dbDatasource;

    @Inject
    @Named("db.username")
    private String dbUsername;

    @Inject
    @Named("db.password")
    private String dbPassword;

    @Inject
    private PersistService persistService;

    @Inject
    public DatabaseDaemon() {
        // Cannot access fields annotated with @Inject here, they are null.
    }

    public void start() {
        if (server == null) {
            logger.info("Database starting...");
            server = new Server();
            server.setAddress(dbAddress);
            server.setPort(dbPort);
            server.setDatabaseName(0, dbName);
            server.setDatabasePath(0, dbPath);
            server.start();
        }
        logger.info("Database started.");

        logger.info("Persistence service starting");
        persistService.start();
        logger.info("Persistence service started.");

        logger.info("Initializing migration service.");
        migration.setDataSource(dbDatasource, dbUsername, dbPassword);
        migration.setSchemas(dbName);
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
