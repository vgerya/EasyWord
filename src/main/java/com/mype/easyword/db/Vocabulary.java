package com.mype.easyword.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Vitaliy Gerya
 */
@Entity
public class Vocabulary {
    @Id
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "creationDate", nullable = false)
    private LocalDateTime creationDate;
    @Column(name="word")
    @OneToMany(mappedBy = "vocabularyId")
    private Set<Word> words;

    @Id
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


    @Override
    public String toString() {
        return "com.mype.easyword.db.Vocabulary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
