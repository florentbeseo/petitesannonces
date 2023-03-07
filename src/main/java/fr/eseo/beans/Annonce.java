package fr.eseo.beans;

public class Annonce
{
    //Attributs
    private int idAnnonce;          //Numéro de l'annonce
    private float prix;             //Prix de l'annonce
    private String extra;           //Cas du €/heure ou /items etc...
    private String descriptif;      //Description de l'annonce
    //private String etat;          //Renseigne l'état structurelle du biens neuf|intacte|usé|abimé|cassé|enPoudre
    private Utilisateur vendeur;    //L'utilisateur qui publie l'annonce
    private boolean categorie;      //Biens  0 | 1  Services
    private boolean isVisible;      //Si l'annonce est visible ou pas
    private boolean isFini;         //Si l'annonce est fini
    //Constructeurs

    //Getters setters


}
