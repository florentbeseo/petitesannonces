package fr.eseo.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
    Permet la gestion de la table annonce sur mariaDB
    @author Amiaud Antoine
    @version 2.5
    @see DAOFactory
 */
public class DAOAnnonceMariaDB implements DAOAnnonce
{
    /*
        Le DAOFactory sert à liée le site à la table annonce
        @author Amiaud Antoine
        @see DAOFactory
    */
    private final DAOFactory daoFactory;
    /*
        Constructeur unique, renseigne le DAOFactory dans lequel cette classe s'implémente
        @author Amiaud Antoine
        @see DAOFactory
    */
    DAOAnnonceMariaDB ( DAOFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouterAnnonce ( Annonce annonce )
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "INSERT INTO annonce(prix , extra , descriptif, etat, img, type, titre, envoi, categorie , isVisible , isFini, vendeur) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"))
        {
            preparedStatement.setFloat(     1,  annonce.getPrix ());
            preparedStatement.setString(    2,  annonce.getExtra ());
            preparedStatement.setString(    3,  annonce.getDescriptif ());
            preparedStatement.setString(    4,  annonce.getEtat ());
            preparedStatement.setString(    5,  annonce.getImg ());
            preparedStatement.setString(    6,  annonce.getType ());
            preparedStatement.setString(    7,  annonce.getTitre ());
            preparedStatement.setDate(      8,  annonce.getEnvoi ());
            preparedStatement.setBoolean(   9,  annonce.isCategorie ());
            preparedStatement.setBoolean(   10,  annonce.isVisible ());
            preparedStatement.setBoolean(   11, annonce.isFini ());
            preparedStatement.setInt(       12, annonce.getVendeur ());

            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void suprimerAnnonce ( Annonce annonce )
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "DELETE FROM annonce WHERE idAnnonce = ?;"))
        {
            preparedStatement.setString(1, Integer.toString ( annonce.getIdAnnonce () ));
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierAnnonce ( Annonce annonce )
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "UPDATE annonce SET idAnnonce=? , prix=? , extra=? , descriptif=?, etat=? , img=? , type=? , titre=? , envoi=?, categorie=? , isVisible=? , isFini=? , vendeur=? WHERE id=?;")){
            preparedStatement.setInt    (1, annonce.getIdAnnonce () );
            preparedStatement.setFloat  (2, annonce.getPrix ()      );
            preparedStatement.setString (3, annonce.getExtra ()     );
            preparedStatement.setString (4, annonce.getDescriptif ());
            preparedStatement.setString (5, annonce.getEtat ()      );
            preparedStatement.setString (6, annonce.getImg ()       );
            preparedStatement.setString (7, annonce.getType ()      );
            preparedStatement.setString (8, annonce.getTitre ()     );
            preparedStatement.setDate   (9, annonce.getEnvoi ()     );
            preparedStatement.setBoolean(10, annonce.isCategorie ()  );
            preparedStatement.setBoolean(11,annonce.isVisible ()    );
            preparedStatement.setBoolean(12,annonce.isFini ()       );
            preparedStatement.setInt    (13,annonce.getVendeur ()   );
            preparedStatement.setInt    (14,annonce.getIdAnnonce () );

            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /*
    @Override
    public Annonce recupAnnonce (String typeA, Boolean categorieA)
    {
        Annonce annonce = new Annonce ();
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT idAnnonce , prix , extra , descriptif, etat, type, titre, categorie , isVisible , isFini, vendeur FROM annonce WHERE categorie='"+categorieA+"' AND type='"+typeA+"';")) {
            while (resultat.next())
            {
                int idAnnonce       = resultat.getInt (     "idAnnonce"     );
                float prix          = resultat.getFloat (   "prix"          );
                String extra        = resultat.getString (  "extra"         );
                String descriptif   = resultat.getString (  "descriptif"    );
                String etat = resultat.getString("etat");
                //String img          = resultat.getString (  "img"           );
                String type = resultat.getString("type");
                String titre = resultat.getString("titre");
                boolean categorie   = resultat.getBoolean ( "categorie"     );
                boolean isVisible   = resultat.getBoolean ( "isVisible"     );
                boolean isFini      = resultat.getBoolean ( "isFini"        );
                int vendeur         = resultat.getInt (     "vendeur"       );


                annonce.setIdAnnonce ( idAnnonce );
                annonce.setPrix ( prix );
                annonce.setExtra ( extra );
                annonce.setDescriptif ( descriptif );
                annonce.setEtat(etat);
                annonce.setType(type);
                annonce.setTitre(titre);
                annonce.setCategorie ( categorie );
                annonce.setVisible ( isVisible );
                annonce.setFini ( isFini );
                annonce.setVendeur ( vendeur );
                //annonce.setImg ( img );

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return annonce;
    }*/


    @Override
    public List<Annonce> recupAnnonce (String typeA)
    {
        List<Annonce> liste_annonce = new ArrayList<>();
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT prix, extra, descriptif, etat , type, titre, envoi, categorie , isVisible , isFini, vendeur FROM annonce WHERE type='"+typeA+"' ;")) {
            while (resultat.next())
            {
                float prix          = resultat.getFloat (   "prix"          );
                String extra        = resultat.getString (  "extra"         );
                String descriptif   = resultat.getString (  "descriptif"    );
                String etat         = resultat.getString("etat");
                //String img          = resultat.getString (  "img"           );
                String type         = resultat.getString("type");
                String titre        = resultat.getString("titre");
                Date envoi          = resultat.getDate ( "envoi" );
                boolean categorie   = resultat.getBoolean ( "categorie"     );
                boolean isVisible   = resultat.getBoolean ( "isVisible"     );
                boolean isFini      = resultat.getBoolean ( "isFini"        );
                int vendeur         = resultat.getInt (     "vendeur"       );

                Annonce annonce = new Annonce();
                annonce.setPrix(prix);
                annonce.setExtra(extra);
                annonce.setDescriptif(descriptif);
                annonce.setEtat(etat);
                annonce.setType(type);
                annonce.setTitre(titre);
                annonce.setEnvoi ( envoi );
                annonce.setCategorie(categorie);
                annonce.setVisible(isVisible);
                annonce.setFini(isFini);
                annonce.setVendeur(vendeur);
                liste_annonce.add(annonce);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return liste_annonce;
    }

    @Override
    public List<Annonce> recupAnnonceCat (Boolean categorieA)
    {
        List<Annonce> liste_annonce = new ArrayList<>();
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT prix, extra, descriptif, etat/*, img*/ , type, titre, envoi, categorie , isVisible , isFini, vendeur FROM annonce;")) {
            while (resultat.next())
            {
                float prix          = resultat.getFloat (   "prix"          );
                String extra        = resultat.getString (  "extra"         );
                String descriptif   = resultat.getString (  "descriptif"    );
                String etat         = resultat.getString("etat");
                //String img          = resultat.getString (  "img"           );
                String type         = resultat.getString("type");
                String titre        = resultat.getString("titre");
                Date envoi          = resultat.getDate ( "envoi" );
                boolean categorie   = resultat.getBoolean ( "categorie"     );
                boolean isVisible   = resultat.getBoolean ( "isVisible"     );
                boolean isFini      = resultat.getBoolean ( "isFini"        );
                int vendeur         = resultat.getInt (     "vendeur"       );

                Annonce annonce = new Annonce();
                annonce.setPrix(prix);
                annonce.setExtra(extra);
                annonce.setDescriptif(descriptif);
                annonce.setEtat(etat);
                //annonce.setImg(img);
                annonce.setType(type);
                annonce.setTitre(titre);
                annonce.setEnvoi (envoi);
                annonce.setCategorie(categorie);
                annonce.setVisible(isVisible);
                annonce.setFini(isFini);
                annonce.setVendeur(vendeur);
                if (annonce.isCategorie() == categorieA){
                    liste_annonce.add(annonce);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return liste_annonce;
    }

    @Override
    public List<Annonce> recupAnnonceVisible (Boolean estVisible)
    {
        List<Annonce> liste_annonce = new ArrayList<>();
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT prix, extra, descriptif, etat , type, titre, categorie , isVisible , isFini, vendeur FROM annonce;")) {
            while (resultat.next())
            {
                float prix          = resultat.getFloat (   "prix"          );
                String extra        = resultat.getString (  "extra"         );
                String descriptif   = resultat.getString (  "descriptif"    );
                String etat         = resultat.getString("etat");
                //String img          = resultat.getString (  "img"           );
                String type         = resultat.getString("type");
                String titre        = resultat.getString("titre");
                boolean categorie   = resultat.getBoolean ( "categorie"     );
                boolean isVisible   = resultat.getBoolean ( "isVisible"     );
                boolean isFini      = resultat.getBoolean ( "isFini"        );
                int vendeur         = resultat.getInt (     "vendeur"       );

                Annonce annonce = new Annonce();
                annonce.setPrix(prix);
                annonce.setExtra(extra);
                annonce.setDescriptif(descriptif);
                annonce.setEtat(etat);
                annonce.setType(type);
                annonce.setTitre(titre);
                annonce.setCategorie(categorie);
                annonce.setVisible(isVisible);
                annonce.setFini(isFini);
                annonce.setVendeur(vendeur);
                if (annonce.isCategorie() == estVisible){
                    liste_annonce.add(annonce);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return liste_annonce;
    }


    @Override
    public Annonce chercherAnnonceParId(int idannonce){
        Annonce annonce = new Annonce();
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT idAnnonce, prix, extra, descriptif, etat , type, titre, categorie , isVisible , isFini, vendeur FROM annonce WHERE idAnnonce='"+idannonce+"' ;")) {
            while (resultat.next())
            {
                int idAnnonce       = resultat.getInt  (     "idAnnonce"       );
                float prix          = resultat.getFloat (   "prix"          );
                String extra        = resultat.getString (  "extra"         );
                String descriptif   = resultat.getString (  "descriptif"    );
                String etat         = resultat.getString("etat");
                //String img          = resultat.getString (  "img"           );
                String type         = resultat.getString("type");
                String titre        = resultat.getString("titre");
                boolean categorie   = resultat.getBoolean ( "categorie"     );
                boolean isVisible   = resultat.getBoolean ( "isVisible"     );
                boolean isFini      = resultat.getBoolean ( "isFini"        );
                int vendeur         = resultat.getInt (     "vendeur"       );

                annonce.setIdAnnonce(idAnnonce);
                annonce.setPrix(prix);
                annonce.setExtra(extra);
                annonce.setDescriptif(descriptif);
                annonce.setEtat(etat);
                annonce.setType(type);
                annonce.setTitre(titre);
                annonce.setCategorie(categorie);
                annonce.setVisible(isVisible);
                annonce.setFini(isFini);
                annonce.setVendeur(vendeur);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    return annonce;
}

    public List<Annonce> recupAnnonceTout ()
    {
        List<Annonce> liste_annonce = new ArrayList<>();
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT prix, extra, descriptif, etat , type, titre, categorie , isVisible , isFini, vendeur FROM annonce;")) {
            while (resultat.next())
            {
                float prix          = resultat.getFloat (   "prix"          );
                String extra        = resultat.getString (  "extra"         );
                String descriptif   = resultat.getString (  "descriptif"    );
                String etat         = resultat.getString("etat");
                //String img          = resultat.getString (  "img"           );
                String type         = resultat.getString("type");
                String titre        = resultat.getString("titre");
                boolean categorie   = resultat.getBoolean ( "categorie"     );
                boolean isVisible   = resultat.getBoolean ( "isVisible"     );
                boolean isFini      = resultat.getBoolean ( "isFini"        );
                int vendeur         = resultat.getInt (     "vendeur"       );

                Annonce annonce = new Annonce();
                annonce.setPrix(prix);
                annonce.setExtra(extra);
                annonce.setDescriptif(descriptif);
                annonce.setEtat(etat);
                annonce.setType(type);
                annonce.setTitre(titre);
                annonce.setCategorie(categorie);
                annonce.setVisible(isVisible);
                annonce.setFini(isFini);
                annonce.setVendeur(vendeur);
                liste_annonce.add(annonce);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return liste_annonce;
    }
}
