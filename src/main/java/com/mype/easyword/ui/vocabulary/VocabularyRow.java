package com.mype.easyword.ui.vocabulary;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;

/**
 * @author Vitaliy Gerya
 */
public class VocabularyRow {
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleObjectProperty<LocalDateTime> creationDate = new SimpleObjectProperty<LocalDateTime>();

    public VocabularyRow() {
    }

    public String getName() {
        return name.get();
    }

    public void setName(final String name) {
        this.name.set(name);
    }

    public LocalDateTime getCreationDate() {
        return creationDate.get();
    }

    public void setCreationDate(final LocalDateTime creationDate) {
        this.creationDate.set(creationDate);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VocabularyRow that = (VocabularyRow) o;

        if (!creationDate.equals(that.creationDate)) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + creationDate.hashCode();
        return result;
    }
}
