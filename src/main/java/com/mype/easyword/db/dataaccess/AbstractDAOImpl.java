package com.mype.easyword.db.dataaccess;

import com.google.inject.Inject;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * @author Vitaliy Gerya
 */
public abstract class AbstractDAOImpl<T> implements AbstractDAO<T> {
    @Inject
    private EntityManager entityManager;
    private final Class<T> entityClass;

    protected AbstractDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Collection<T> getAll() {
//        entityManager.createQuery();
        return null;
    }
}
