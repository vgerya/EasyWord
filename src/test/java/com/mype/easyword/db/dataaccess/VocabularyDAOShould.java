package com.mype.easyword.db.dataaccess;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.mype.easyword.EasyWordModule;
import com.mype.easyword.db.Vocabulary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.datasetloadstrategy.impl.CleanInsertLoadStrategy;

import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * @author Vitaliy Gerya
 */
public class VocabularyDAOShould {
    @Inject
    private VocabularyDAO vocabularyDAO;

    @Before
    public void setUp() throws Exception {
        Guice.createInjector(new EasyWordModule(), new JpaPersistModule("VocabularyUnit"));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    @DataSet(value = "VocabularyDAOShould.returnEmptyListIfNoVocabulariesArePresented.xml",
            loadStrategy = CleanInsertLoadStrategy.class)
    public void returnEmptyListIfNoVocabulariesArePresented() throws Exception {
        Collection<Vocabulary> allVocabularies = vocabularyDAO.getAll();

        assertThat(allVocabularies).isNotNull().isEmpty();
    }
}
