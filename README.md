# petitesannonces

Pour utiliser notre site il vous faut avoir une base de donnée, petiteannonce contient deux tables, utilisateur et annonce: 

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

create database petiteannonce;
use petiteannonce;
create table utilisateur
( 
idUtilisateur int not null auto_increment primary key, 
ind int, 
pseudo varchar(20), 
adresse varchar(30), 
mdp varchar(30), 
nom varchar(20), 
prenom varchar(20), 
anniversaire varchar(9), 
tel varchar(15), 
isAdmin BOOLEAN, 
isBloque BOOLEAN
);
create table annonce
(
idAnnonce int not null auto_increment primary key, 
prix decimal(6,2), 
extra varchar(10), 
descriptif varchar(1000), 
etat varchar(20), 
img varchar(30), 
type varchar(20), 
titre varchar(30), 
categorie boolean, 
isVisible boolean, 
isFini boolean, 
vendeur int not null, 
foreign key(vendeur) references utilisateur(idUtilisateur) on delete cascade
);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

On propose différent profils pour pré-remplire la table utilisateur : 

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO utilisateur(ind, pseudo,adresse,mdp,nom,prenom,anniversaire,tel,isAdmin,isBloque) VALUES(-3,"Patr1k","patrick@mail.fr","Pat123","Patrick","Meunier",0610000000,1987-10-09,0,0);
INSERT INTO utilisateur(ind, pseudo,adresse,mdp,nom,prenom,anniversaire,tel,isAdmin,isBloque) VALUES(5,"Est3lle","estelle@mail.fr","Angers456","Estelle","Lambert",0620000000,1976-05-12,0,0);
INSERT INTO utilisateur(ind, pseudo,adresse,mdp,nom,prenom,anniversaire,tel,isAdmin,isBloque) VALUES(0,"Pulpe","stan@mail.fr","CR7","Stan","Gomez",0630000000,2004-03-27,0,0);
INSERT INTO utilisateur(ind, pseudo,adresse,mdp,nom,prenom,anniversaire,tel,isAdmin,isBloque) VALUES(10,"AdMineur","admin@mail.fr","admin","AD","Boulot","0640000000",1999-09-26,1,0);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

De même on fournit de quoi remplir les annonces :

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( 14.00, /item, "Ensemble de 20 vis acier et inox", "Neuf", "img", "type", "titre, 0, 1, 1, 2);
INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /item, "desc", "etat", "img", "type", "titre, 0, 1, 1, 3);
INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /item, "desc", "etat", "img", "type", "titre, 0, 1, 0, 2);
INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /item, "desc", "etat", "img", "type", "titre, 0, 0, 1, 1);
INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /item, "desc", "etat", "img", "type", "titre, 0, 0, 0, 3);

INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /heure, "desc", "", "img", "type", "titre, 1, 1, 1, 2);
INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /heure, "desc", "", "img", "type", "titre, 1, 1, 1, 3);
INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /heure, "desc", "", "img", "type", "titre, 1, 1, 0, 2);
INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /heure, "desc", "", "img", "type", "titre, 1, 0, 1, 1);
INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, /heure, "desc", "", "img", "type", "titre, 1, 0, 0, 3);
