package fr.eseo.beans;

public class Utilisateur
{
    //attributs
    private String adresse;     //addresse mail de l'utilisateur
    private String mdp;         //mot de passe de l'utilisateur
    private String nom;         //nom de l'utilisateur
    private String prenom;      //prénom de l'utilisateur
    private String anniversaire;//date d'anniversaire format aa/mm/jj
    private boolean isAdmin;    //n'est pas admin  0 | 1 est admin
    private boolean isBloque;   //n'est pas bloqué 0 | 1 est bloqué

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

    public String getNom ( )
    {
        return nom;
    }

    public void setNom ( String nom )
    {
        this.nom = nom;
    }

    public String getPrenom ( )
    {
        return prenom;
    }

    public void setPrenom ( String prenom )
    {
        this.prenom = prenom;
    }

    public String getAnniversaire ( )
    {
        return anniversaire;
    }

    public void setAnniversaire ( String anniversaire )
    {
        this.anniversaire = anniversaire;
    }

    public boolean isAdmin ( )
    {
        return isAdmin;
    }

    public void setAdmin ( boolean admin )
    {
        isAdmin = admin;
    }

    public boolean isBloque ( )
    {
        return isBloque;
    }

    public void setBloque ( boolean bloque )
    {
        isBloque = bloque;
    }
}
