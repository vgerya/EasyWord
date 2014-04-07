CREATE TABLE Vocabulary (
  id IDENTITY               NOT NULL PRIMARY KEY,
  name         VARCHAR(256) NOT NULL,
  creationDate TIMESTAMP    NOT NULL
);

CREATE TABLE Word (
  id IDENTITY               NOT NULL PRIMARY KEY,
  word         VARCHAR(256) NOT NULL,
  translation  VARCHAR(256) NOT NULL,
  vocabularyId BIGINT       NOT NULL,

  CONSTRAINT vocabularyFK FOREIGN KEY (vocabularyId) REFERENCES Vocabulary (id)
);

/*
DROP TABLE Word;
DROP TABLE Vocabulary;

INSERT INTO Vocabulary (name, creationDate)
VALUES ('test1', now());

INSERT INTO Word (word, translation, vocabularyId)
VALUES ('word', 'слово', 0);

SELECT
  *
FROM Vocabulary;
SELECT
  *
FROM Word;
*/