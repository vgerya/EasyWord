package com.mype.easyword.service;

import com.mype.easyword.ui.vocabulary.Vocabulary;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public interface VocabularyService {
    List<Vocabulary> getVocabularies();

    void removeVocabulary(final Vocabulary vocabulary);

    void addVocabulary(final Vocabulary vocabulary);

    void editVocabulary(final Vocabulary vocabulary);
}
