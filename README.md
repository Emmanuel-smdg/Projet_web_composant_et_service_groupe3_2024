# Projet Gestion Produits Groupe 3

Ce projet est une application Spring Boot de gestion de produits, avec une intégration à PostgreSQL et Prometheus pour la surveillance des performances.

## Prérequis

Avant de commencer, assurez-vous d'avoir les outils suivants installés sur votre système :

- [PostgreSQL](https://www.postgresql.org/download/) (version recommandée : 12+)
- [pgAdmin](https://www.pgadmin.org/download/) ou `psql` (outil en ligne de commande PostgreSQL)
- [Talend Open Studio](https://drive.google.com/file/d/1IQA6Q_wPUitwdrcEanG29PX7WsnuOLoJ/view?usp=sharing)
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 ou supérieure)
- [Prometheus](https://prometheus.io/download/)

## Installation

### 1. Configuration de la base de données PostgreSQL

1. Téléchargez et installez PostgreSQL si ce n'est pas déjà fait.
2. Exécutez le script SQL `setup.sql` pour créer les tables nécessaires :
    - Ouvrez un terminal et accédez au répertoire contenant `setup.sql`.
    - Connectez-vous à PostgreSQL et exécutez le script :  
      ```bash
      psql -U postgres -f script.sql
      ```
    - Vérifiez que les tables ont été créées avec succès :
      ```bash
      \c groupe3_db_produits
      \dt groupe3.*
      ```
    - Vous devriez voir les tables `produit`, `client`, et `vente`.

### 2. Préparation des Fichiers de Données

1. Créez un répertoire sur votre machine :  
   ```bash
   C:\talend_groupe3\
2. Placez le fichier Excel de données nommé `data_groupe3.xlsx` dans ce répertoire.

## Importation et Exécution du Job dans Talend Open Studio

1. **Lancement de Talend Open Studio** :
- Ouvrez Talend Open Studio.

2. **Importation du Job** :
- Cliquez sur **File** > **Import Items**.
- Sélectionnez "Select Root Directory" et naviguez jusqu'au dossier contenant les fichiers exportés du job (`Job_exporte\PROJET_GROUPE3`) ou le fichier zip `job_exporte.zip`.
- Cochez les éléments à importer (job, métadonnées, contextes).
- Cliquez sur **Finish**.

3. **Configuration du Job** :
- Dans le repository, naviguez jusqu'au job importé.
- Double-cliquez sur le job pour l'ouvrir dans l'espace de travail.
- Vérifiez les composants et leurs configurations, en particulier les chemins des fichiers et les paramètres de connexion à la base de données.

4. **Exécution du Job** :
- Cliquez sur l'onglet **Run** en bas de la fenêtre.
- Cliquez sur le bouton **Run** (icône de lecture verte) pour exécuter le job.
- Observez la console pour voir les logs d'exécution.

## Vérification des Résultats

1. Connectez-vous à votre base de données PostgreSQL.
2. Vérifiez que les données ont été correctement insérées dans les tables. Exemples de commandes SQL pour vérifier :
```sql
SELECT * FROM groupe3.produit;
SELECT * FROM groupe3.client;
SELECT * FROM groupe3.vente;
```
## Démarrage de l'Application

1. **Exécution de l'application** :
   - Ouvrez un terminal ou une invite de commande.
   - Naviguez jusqu'au répertoire contenant le fichier `app_gestion_produits_groupe3.jar`.
   - Exécutez la commande suivante pour démarrer l'application :
     ```bash
     java -jar app_gestion_produits_groupe3.jar
     ```
   - L'application démarrera sur le port `8080`.

2. **Accès à l'Application** :
   - Vous pouvez accéder à l'application via votre navigateur à l'adresse suivante :
     ```
     http://localhost:8080
     ```

3. **Test de l'Application** :
   - Utilisez un outil comme **Postman** pour tester les différents endpoints de l'application.
   - Pour plus de détails sur les endpoints disponibles, consultez le fichier `endpoint.txt`.
   
## Démarrage de Prometheus

1. **Téléchargement de Prometheus** :
   - Téléchargez le binaire depuis le site officiel de [Prometheus](https://prometheus.io/download/).

2. **Installation de Prometheus** :
   - Extrayez le contenu du fichier compressé dans un dossier de votre choix.
   - Accédez à ce dossier et modifiez le fichier `prometheus.yml` avec la configuration du projet (remplacez le contenu par celui du fichier `prometheus.yml` fourni avec ce projet).

3. **Démarrage de Prometheus** :
   - Ouvrez un terminal ou une invite de commande en tant qu'administrateur.
   - Accédez au dossier contenant le binaire Prometheus extrait et exécutez la commande suivante :
     ```bash
     .\prometheus.exe --config.file prometheus.yml --web.listen-address ":9090" --storage.tsdb.path "données"
     ```

4. **Accès à l'interface Prometheus** :
   - Une fois Prometheus démarré, ouvrez un navigateur et rendez-vous à l'adresse suivante pour accéder à l'interface Prometheus :
     ```
     http://localhost:9090
     ```

5. **Surveillance des métriques** :
   - Utilisez l'interface web de Prometheus pour visualiser et surveiller les métriques de votre application exposées via `/actuator/prometheus`.
   - 
## Auteur

Ce projet a été développé par **Groupe 3** dans le cadre du PROJET DE DEVELOPPEMENT DE BASE DE COMPOSANT ET SERVICES WEB. Le développement inclut l'intégration avec PostgreSQL, l'automatisation des processus avec Talend Open Studio, et la surveillance de l'application Spring Boot et Prometheus.

## Licence

Ce projet est sous licence **MIT** - Voir le fichier [LICENSE](LICENSE) pour plus de détails.


