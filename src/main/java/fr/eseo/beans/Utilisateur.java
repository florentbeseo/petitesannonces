package fr.eseo.beans;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Date;

/*
    L'utilisateur est la classe qui represente les clients du site, ils peuvent publier ou voir des annonces
    @author Amiaud Antoine
    @version 1.3
    @see Annonce
 */
public class Utilisateur
{
    //attributs
    /*
        Id de l'utilisateur
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private int idUtilisateur;
    /*
        Indexe de satisfaction de l'utilisateur de -10 à 10 pour savoir s'il agit bien sur le site
        @author Amiaud Antoine
        @version 1.2
        @since 1.1
     */
    private int ind = 0;
    /*
        Pseudonyme de l'utilisateur
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private String pseudo;
    /*
        Adresse mail de l'utilisateur
        @author Amiaud Antoine
        @version 1.1
        @since 0.0
     */
    private String adresse;
    /*
        Mot de passe de l'utilisateur encrypté
        @author Amiaud Antoine
        @version 1.5
        @since 0.0
     */
    private String mdp;
    /*
        Nom de l'utilisateur
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private String nom;
    /*
        Prénom de l'utilisateur
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private String prenom;
    /*
        Date d'anniversaire format aaaa-mm-jj
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private Date anniversaire ;
    /*
        Téléphone de l'utilisateur
        @author Amiaud Antoine
        @version 1.1
        @since 0.0
     */
    private String tel;
    /*
        N'est pas admin  0 | 1 est admin
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private boolean isAdmin = false;
    /*
        N'est pas bloqué 0 | 1 est bloqué
        @author Amiaud Antoine
        @version 1.1
        @since 1.1
     */
    private boolean isBloque = false;

    //constructeur
    /*
        Constructeur vide
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
        @param aucun
        @return aucun
     */
    public Utilisateur()
    {
    }
    /*
        Constructeur de base, permet d'effectuer des tests basiques liés à l'utilisateur
        @author Amiaud Antoine
        @version 1.0
        @since 0.1
        @param adresse String l'adresse mail de l'utilisateur
        @param mdp String le mot de passe de l'utilisateur
        @return aucun
     */
    public Utilisateur(String adresse, String mdp)
    {
        this.adresse = adresse;
        this.mdp = mdp;
    }
    /*
        Constructeur complet, nécessaire à la communication à la base de donnée
        @author Amiaud Antoine
        @version 1.2
        @since 0.1
        @param pseudo String l'alias de l'utilisateur sur le site
        @param adresse String l'adresse mail de l'utilisateur
        @param mdp String le mot de passe de l'utilisateur
        @param nom String le nom de l'utilisateur
        @param prenom String le prénom de l'utilisateur
        @param anniversaire Date la date de naissance de l'utilisateur
        @param tel String le numéro de téléphone de l'utilisateur
        @return aucun
     */
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
    /*
    Constructeur imcomplet, ne nécessite aucun mot de passe, sert à l'encryption du mot de passe de l'utilisateur à l'inscription
        @author Amiaud Antoine
        @version 1.2
        @since 0.1
        @param pseudo String l'alias de l'utilisateur sur le site
        @param adresse String l'adresse mail de l'utilisateur
        @param nom String le nom de l'utilisateur
        @param prenom String le prénom de l'utilisateur
        @param anniversaire Date la date de naissance de l'utilisateur
        @param tel String le numéro de téléphone de l'utilisateur
        @return aucun
     */
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

    /*
        permet de set le mdp de l'utilisateur en passant par une encryption du mdp via une bibliothèque BCrypt
        @author Amiaud Antoine
        @version 1.1
        @since 1.2
        @param mdp String
        @return aucun
     */
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
    /*
            permet de vérifier que le mot de passe saisit à l'inscription est en accord avec la base de donnée
            @author Amiaud Antoine
            @version 1.1
            @since 1.2
            @param mdp String
            @return boolean 1 si bon mdp 0 sinon
         */
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
