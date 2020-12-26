# Site web dédié à une librairie

## Ressources



## Re Installer la base de données du projet à partir des scripts SQL

Nom : PostgreSQL
Version : 11


## Configurer la base de données
- Créer la base de données sous PosgreSQL :
  ![Créer la base de données depuis pgAdmin4](./documentation/images/create_database.png)
- Ouvrir une console SQL (`Menu Tools > Query tool`)

## Sauvegarder la base de données

### Sauvegarde sous forme de script SQL

Ouvrir pg Admin 4 dans un navigateur

1. Sauvegarger le fichier pour la structure de la bdd : tables et séquences à minima.

- Click droit sur la base cible (exemple : library)
- Choisir backup
- Une popin s'ouvre :
- Dans le premier onglet "General" cliquez sur le bouton à droite du premier champs nommé "Filename" pour :
    - Choisir SQL en bas à droite dans la liste de choix et seulement à ce moment remonter dans le champs pour choisr le chemin où stocker le fichier puis entrer à la suite le nom du fichier.
    - Une fois revenu sur la popin initial dans le premier onglet choisr :
        - `PLAIN` (plain text)
        - `UTF-8`
        - `postgres`
- Aller dans le second onglet nommé "Dump options" et Choisir :
    - Type of objects > `Only schema`
    - Queries > `Use column inserts`
    - Queries > `Use insert commans`


2. Sauvegarder le fichier pour le données contenues dans les tables.

- Click droit sur la base cible (exemple : library)
- Choisir backup
- Une popin s'ouvre :
- Dans le premier onglet "General" cliquez sur le bouton à droite du premier champs nommé "Filename" pour :
    - Choisir SQL en bas à droite dans la liste de choix et seulement à ce moment remonter dans le champs pour choisr le chemin où stocker le fichier puis entrer à la suite le nom du fichier.
    - Une fois revenu sur la popin initial dans le premier onglet choisr :
        - `PLAIN` (plain text)
        - `UTF-8`
        - `postgres`
- Aller dans le second onglet nommé "Dump options" et Choisir :
    - Type of objects > `Only data`
    - Queries > `Use column inserts`
    - Queries > `Use insert commands`
