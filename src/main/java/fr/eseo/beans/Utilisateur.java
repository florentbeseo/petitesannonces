package fr.eseo.beans;

public class Utilisateur
{
    //attributs
    private String adresse; //addresse mail de l'utilisateur
    private String mdp;     //mot de passe de l'utilisateur

    //constructeur
    public Utilisateur()
    {
    }
    public Utilisateur(String adresse,String mdp)
    {
        this.adresse = adresse;
        this.mdp = mdp;
    }

    //getters setters

    public String getAdresse ( )
    {
        return adresse;
    }

    public void setAdresse ( String adresse )
    {
        this.adresse = adresse;
    }

    public String getMdp ( )
    {
        return mdp;
    }

    public void setMdp ( String mdp )
    {
        this.mdp = mdp;
    }
}
