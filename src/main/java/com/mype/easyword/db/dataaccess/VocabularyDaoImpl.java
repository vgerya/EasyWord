package com.mype.easyword.db.dataaccess;

import com.mype.easyword.db.Vocabulary;

/**
 * @author Vitaliy Gerya
 */
public class VocabularyDaoImpl extends AbstractDAOImpl<Vocabulary> implements VocabularyDAO {
    protected VocabularyDaoImpl() {
        super(Vocabulary.class);
    }
}
