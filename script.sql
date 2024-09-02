-- Création de l'utilisateur
CREATE USER groupe3_user WITH PASSWORD 'groupe3_user';

-- Création de la base de données
CREATE DATABASE groupe3_db_produits;

-- Connexion à la nouvelle base de données
\c groupe3_db_produits

-- Création du schéma
CREATE SCHEMA groupe3;

-- Donner les privilèges à l'utilisateur sur le schéma
GRANT ALL PRIVILEGES ON SCHEMA groupe3 TO groupe3_user;

-- Création des tables dans le schéma groupe3
SET search_path TO groupe3;

-- Table produit
CREATE TABLE produit (
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL,
    marque VARCHAR(50),
    prix DECIMAL(10, 2),
    poids DECIMAL(8, 2),
    couleur VARCHAR(30),
    quantite INTEGER,
    description TEXT
);

-- Table client
CREATE TABLE client (
    user_id SERIAL PRIMARY KEY,
    nom_complet VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    ville VARCHAR(50),
    type_carte_utilise VARCHAR(50)
);

-- Table vente
CREATE TABLE vente (
    id_produit INTEGER REFERENCES produit(id),
    id_client INTEGER REFERENCES client(user_id),
    date_achat VARCHAR(50) NOT NULL,
    heure_achat VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_produit, id_client)
);

-- Donner les privilèges à l'utilisateur sur les tables
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA groupe3 TO groupe3_user;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA groupe3 TO groupe3_user;