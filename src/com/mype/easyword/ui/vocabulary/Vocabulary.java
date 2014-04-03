package com.mype.easyword.ui.vocabulary;

import java.util.Date;

/**
 * @author Vitaliy Gerya
 */
public class Vocabulary {
    private String name;
    private Date creationDate;

    public Vocabulary() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }
}
