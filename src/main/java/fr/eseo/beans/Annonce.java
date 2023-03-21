package fr.eseo.beans;
import java.sql.Date;
/*
L'annonce est un article qu'un utilisateur peut publier sur le site, elle prend la forme d'un bien ou d'un service
@author Amiaud Antoine
@version 1.4
@see Utilisateur
 */

public class Annonce
{
    //Attributs
    /*
        Numéro de l'annonce
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private int idAnnonce;
    /*
        Prix de l'annonce
        @author Amiaud Antoine
        @version 1.1
        @since 1.2
     */
    private float prix;
    /*
        Cas du €/heure ou /items ou objet ou total etc...
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private String extra;
    /*
        Description de l'annonce
        @author Amiaud Antoine
        @version 1.2
        @since 1.1
     */
    private String descriptif;
    /*
        Renseigne l'état structurel du bien Neuf|Intacte|Occasion|Casse|EnPoudre
        @author Amiaud Antoine
        @version 1.2
        @since 1.2
     */
    private String etat;
    /*
        nom de l'image de l'annonce
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private String img;
    /*
        Pour les biens      :   Vehicule|Mobilier|Exterieur|Sport|Animalier|Numerique|Loisir|Travail|Bricolage
        Pour les services   :   Demenagement|Chantier|Babysiting|Accompagnement|Photographie|Service
        @author Amiaud Antoine
        @version 1.3
        @since 1.3
     */
    private String type;
    /*
        Titre de l'annonce
        @author Amiaud Antoine
        @version 1.0
        @since 1.4
     */
    private String titre;
    /*
        Date de mise en ligne de l'annonce
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private Date envoi;
    /*
        Biens  0 | 1  Services
        @author Amiaud Antoine
        @version 1.1
        @since 0.0
        @see AutreClasse
     */
    private boolean categorie;
    /*
        Si l'annonce est visible ou pas
        @author Amiaud Antoine
        @version 1.0
        @since 0.1
     */
    private boolean isVisible = false;
    /*
        Si l'annonce est fini : non publiée 0 | 1 publiée
        @author Amiaud Antoine
        @version 1.1
        @since 1.1
     */

    private boolean isFini = false;
    /*
        L'idUtilisateur qui publie l'annonce
        @author Amiaud Antoine
        @version 1.1
        @since 0.2
     */
    private int vendeur;

    //Constructeurs

    //Getters setters
    /*
        Constructeur vide
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
        @param aucun
        @return aucun
     */
    public Annonce(){}
    /*
        Constructeur complet sert à la comunication à la base de donnée
        @author Amiaud Antoine
        @version 1.3
        @since 1.3
        @param prix float le prix de l'article
        @param extra String indication suplémentaire pour le prix
        @param descriptif String courte desciption de l'article
        @param etat String intégrité physique du bien nul si service
        @param img String nom de l'image lié à l'article /non-incorporé pour le moment/
        @param type Sting renseignement sur la qualité d'un bien
        @param titre String Court message qui sera affiché en haut de l'annonce
        @param categorie boolean 0 = bien, 1 = service
        @param vendeur int renseigne le idUtilisateur du vendeur de l'annonce
        @see Utilisateur
        @see Annonce
        @return aucun
     */
    public Annonce(float prix, String extra, String descriptif, String etat, String img, String type,String titre, boolean categorie, int vendeur){
        this.prix = prix;
        this.extra = extra;
        this.descriptif = descriptif;
        this.etat = etat;
        this.type = type;
        this.titre = titre;
        this.categorie = categorie;
        this.vendeur = vendeur;
    }

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

    public String getEtat ( )
    {
        return etat;
    }

    public void setEtat ( String etat )
    {
        this.etat = etat;
    }

    public String getImg ( )
    {
        return img;
    }

    public void setImg ( String img )
    {
        this.img = img;
    }

    public String getType ( )
    {
        return type;
    }

    public void setType ( String type )
    {
        this.type = type;
    }

    public String getTitre ( )
    {
        return titre;
    }

    public void setTitre ( String titre )
    {
        this.titre = titre;
    }

    public java.sql.Date getEnvoi ( )
    {
        return envoi;
    }

    public void setEnvoi ( java.sql.Date envoi )
    {
        this.envoi = envoi;
    }
}
