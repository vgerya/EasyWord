package com.mype.easyword;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.mype.easyword.db.DatabaseDaemon;
import com.mype.easyword.service.VocabularyService;
import com.mype.easyword.service.VocabularyServiceImpl;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class EasyWordModule extends AbstractModule {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EasyWordModule.class);
    private static final String DB_PROPERTIES_FILE = "config/db.properties";

    @Override
    protected void configure() {
        try {
            Properties props = loadProperties(DB_PROPERTIES_FILE);
            logger.info("Loaded properties from file {}", DB_PROPERTIES_FILE);
            logger.debug("Content of {}: \n{}.", DB_PROPERTIES_FILE, props);
            Names.bindProperties(binder(), props);
        } catch (Exception ex) {
            logger.error("Cannot load properties from file " + DB_PROPERTIES_FILE, ex);
        }
        // Binds our resource bundle that contains localized Strings
        bind(ResourceBundle.class).toInstance(ResourceBundle.getBundle("bundles.messages", Locale.getDefault()));
        bind(DatabaseDaemon.class);// to(DatabaseDaemon.class);

        bind(VocabularyService.class).to(VocabularyServiceImpl.class);
    }

    private Properties loadProperties(final String propertiesPath) throws IOException {
        ClassLoader loader = getClass().getClassLoader();
        URL url = loader.getResource(propertiesPath);
        final Properties properties = new Properties();
        properties.load(url.openStream());

        return properties;
    }
}
