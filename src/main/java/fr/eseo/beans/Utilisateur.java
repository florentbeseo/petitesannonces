package fr.eseo.beans;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Date;

/*
Description de la classe
@author Nom
@version 2.1
@since 1.3
@see AutreClasse
 */
public class Utilisateur
{
    //attributs
    private int idUtilisateur;  //Id de l'utilisateur
    private int ind = 0;            //Indexe de satisfaction de l'utilisateur
    private String pseudo;      //Pseudonyme de l'utilisateur
    private String adresse;     //Adresse mail de l'utilisateur
    private String mdp;         //Mot de passe de l'utilisateur encrypté
    private String nom;         //Nom de l'utilisateur
    private String prenom;      //Prénom de l'utilisateur
    private Date anniversaire ;//Date d'anniversaire format aa/mm/jj
    private String tel;         //Téléphone de l'utilisateur
    private boolean isAdmin = false;    //N'est pas admin  0 | 1 est admin
    private boolean isBloque = false;   //N'est pas bloqué 0 | 1 est bloqué

    //constructeur
    public Utilisateur()
    {
    }

    public Utilisateur(String adresse, String mdp)
    {
        this.adresse = adresse;
        this.mdp = mdp;
    }
    public Utilisateur(String pseudo, String adresse, String mdp, String nom, String prenom, Date anniversaire, String tel)
    {
        this.ind = 0;
        this.pseudo = pseudo;
        this.adresse = adresse;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.anniversaire = anniversaire;
        this.tel = tel;
    }
    public Utilisateur(String pseudo, String adresse, String nom, String prenom, Date anniversaire, String tel)
    {
        this.ind = 0;
        this.pseudo = pseudo;
        this.adresse = adresse;
        this.nom = nom;
        this.prenom = prenom;
        this.anniversaire = anniversaire;
        this.tel = tel;
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

    public String getMdp ( )   { return mdp; }

    public void setMdpC ( String mdp )
    {
        this.mdp =  BCrypt.hashpw(mdp, BCrypt.gensalt());
    }
    public void setMdp ( String mdp ) { this.mdp = mdp; }

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

    public java.sql.Date getAnniversaire ( )
    {
        return anniversaire;
    }

    public void setAnniversaire ( java.sql.Date anniversaire )
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

    public boolean isBonMdp( String mdp ) {
        if(BCrypt.checkpw(mdp, this.mdp))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getPseudo ( )
    {
        return pseudo;
    }

    public void setPseudo ( String pseudo )
    {
        this.pseudo = pseudo;
    }

    public int getIdUtilisateur ( )
    {
        return idUtilisateur;
    }

    public void setIdUtilisateur ( int idUtilisateur )
    {
        this.idUtilisateur = idUtilisateur;
    }

    public String getTel ( )
    {
        return tel;
    }

    public void setTel ( String tel )
    {
        this.tel = tel;
    }

    public int getInd ( )
    {
        return ind;
    }

    public void setInd ( int ind )
    {
        this.ind = ind;
    }
}
