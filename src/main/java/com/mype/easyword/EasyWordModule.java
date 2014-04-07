package com.mype.easyword;

import com.google.inject.AbstractModule;
import com.mype.easyword.db.DatabaseDaemon;
import com.mype.easyword.service.VocabularyService;
import com.mype.easyword.service.VocabularyServiceImpl;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class EasyWordModule extends AbstractModule {
    @Override
    protected void configure() {
        // Binds our resource bundle that contains localized Strings
        bind(ResourceBundle.class).toInstance(ResourceBundle.getBundle("bundles.messages", Locale.getDefault()));

        bind(DatabaseDaemon.class).toInstance(new DatabaseDaemon());

        bind(VocabularyService.class).to(VocabularyServiceImpl.class);
    }
}
