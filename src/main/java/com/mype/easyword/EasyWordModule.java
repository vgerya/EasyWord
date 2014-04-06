package com.mype.easyword;

import com.google.inject.AbstractModule;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class EasyWordModule extends AbstractModule {
    @Override
    protected void configure() {
        // Binds our resource bundle that contains localized Strings
//        bind(ResourceBundle.class).annotatedWith(Names.named("i18n-resources")).toInstance(ResourceBundle.getBundle(FxmlExampleApp.class.getName()));
        bind(ResourceBundle.class).toInstance(ResourceBundle.getBundle("bundles.messages", Locale.getDefault()));
    }
}
