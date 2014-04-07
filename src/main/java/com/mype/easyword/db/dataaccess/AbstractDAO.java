package com.mype.easyword.db.dataaccess;

import java.util.Collection;

/**
 * @author Vitaliy Gerya
 */
public interface AbstractDAO<T> {
    Collection<T> getAll();
}
