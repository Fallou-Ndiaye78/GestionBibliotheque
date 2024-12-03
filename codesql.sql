
CREATE TABLE Bibliotheque (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE Membre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    prenom VARCHAR(50) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    adresse VARCHAR(150),
    telephone VARCHAR(20),
    email VARCHAR(50),
    bibliotheque_id INT,
    FOREIGN KEY (bibliotheque_id) REFERENCES Bibliotheque(id) ON DELETE SET NULL
);

CREATE TABLE Compte (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date_creation DATE NOT NULL,
    membre_id INT UNIQUE,
    penalite DECIMAL(10, 2) DEFAULT 0,
    FOREIGN KEY (membre_id) REFERENCES Membre(id) ON DELETE CASCADE
);

CREATE TABLE Article (
    reference VARCHAR(20) PRIMARY KEY,
    titre VARCHAR(100) NOT NULL,
    type ENUM('Livre', 'CD', 'DVD') NOT NULL,
    disponible BOOLEAN DEFAULT TRUE,
    bibliotheque_id INT,
    FOREIGN KEY (bibliotheque_id) REFERENCES Bibliotheque(id) ON DELETE SET NULL
);

CREATE TABLE Livre (
    reference VARCHAR(20) PRIMARY KEY,
    auteur VARCHAR(100),
    isbn INT,
    FOREIGN KEY (reference) REFERENCES Article(reference) ON DELETE CASCADE
);

CREATE TABLE CD (
    reference VARCHAR(20) PRIMARY KEY,
    duree INT NOT NULL,
    FOREIGN KEY (reference) REFERENCES Article(reference) ON DELETE CASCADE
);

CREATE TABLE DVD (
    reference VARCHAR(20) PRIMARY KEY,
    duree INT NOT NULL,
    FOREIGN KEY (reference) REFERENCES Article(reference) ON DELETE CASCADE
);

CREATE TABLE Emprunt (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date_emprunt DATE NOT NULL,
    date_retour_prevue DATE,
    compte_id INT,
    article_reference VARCHAR(20),
    FOREIGN KEY (compte_id) REFERENCES Compte(id) ON DELETE CASCADE,
    FOREIGN KEY (article_reference) REFERENCES Article(reference) ON DELETE CASCADE
);

INSERT INTO Bibliotheque (nom) VALUES ('Bibliothèque Centrale');

-- Insertion d'un membre
INSERT INTO Membre (prenom, nom, adresse, telephone, email, bibliotheque_id)
VALUES ('John', 'Doe', '123 Rue Exemple', '0123456789', 'john@example.com', 1);

-- Insertion d'un compte pour le membre
INSERT INTO Compte (date_creation, membre_id, penalite)
VALUES (CURRENT_DATE, 1, 0);

-- Insertion d'un article de type Livre
INSERT INTO Article (reference, titre, type, disponible, bibliotheque_id)
VALUES ('L1', 'Les Misérables', 'Livre', TRUE, 1);

INSERT INTO Livre (reference, auteur, isbn)
VALUES ('L1', 'Victor Hugo', 123456);

-- Insertion d'un article de type CD
INSERT INTO Article (reference, titre, type, disponible, bibliotheque_id)
VALUES ('C1', 'Greatest Hits', 'CD', TRUE, 1);

INSERT INTO CD (reference, duree)
VALUES ('C1', 60);

-- Insertion d'un article de type DVD
INSERT INTO Article (reference, titre, type, disponible, bibliotheque_id)
VALUES ('D1', 'Inception', 'DVD', TRUE, 1);

INSERT INTO DVD (reference, duree)
VALUES ('D1', 120);

-- Insertion d'un emprunt pour un article
INSERT INTO Emprunt (date_emprunt, date_retour_prevue, compte_id, article_reference)
VALUES (CURRENT_DATE, DATE_ADD(CURRENT_DATE, INTERVAL 14 DAY), 1, 'L1');