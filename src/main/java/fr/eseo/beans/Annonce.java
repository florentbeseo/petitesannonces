package fr.eseo.beans;

public class Annonce
{
    //Attributs
    private int idAnnonce;          //Numéro de l'annonce
    private float prix;             //Prix de l'annonce
    private String extra;           //Cas du €/heure ou /items etc...
    private String descriptif;      //Description de l'annonce
    //private String etat;          //Renseigne l'état structurelle du biens neuf|intacte|usé|abimé|cassé|enPoudre
    private int vendeur;            //L'idUtilisateur qui publie l'annonce
    private boolean categorie;      //Biens  0 | 1  Services
    private boolean isVisible;      //Si l'annonce est visible ou pas
    private boolean isFini;         //Si l'annonce est fini
    //Constructeurs

    //Getters setters


    public int getIdAnnonce ( )
    {
        return idAnnonce;
    }

    public void setIdAnnonce ( int idAnnonce )
    {
        this.idAnnonce = idAnnonce;
    }

    public float getPrix ( )
    {
        return prix;
    }

    public void setPrix ( float prix )
    {
        this.prix = prix;
    }

    public String getExtra ( )
    {
        return extra;
    }

    public void setExtra ( String extra )
    {
        this.extra = extra;
    }

    public String getDescriptif ( )
    {
        return descriptif;
    }

    public void setDescriptif ( String descriptif )
    {
        this.descriptif = descriptif;
    }

    public int getVendeur ( )
    {
        return vendeur;
    }

    public void setVendeur ( int vendeur )
    {
        this.vendeur = vendeur;
    }

    public boolean isCategorie ( )
    {
        return categorie;
    }

    public void setCategorie ( boolean categorie )
    {
        this.categorie = categorie;
    }

    public boolean isVisible ( )
    {
        return isVisible;
    }

    public void setVisible ( boolean visible )
    {
        isVisible = visible;
    }

    public boolean isFini ( )
    {
        return isFini;
    }

    public void setFini ( boolean fini )
    {
        isFini = fini;
    }


}
