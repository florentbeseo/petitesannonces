package fr.eseo.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DAOAnnoncesMariaDB implements DAOAnnonce
{
    private final DAOFactory daoFactory;
    DAOAnnoncesMariaDB(DAOFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouterAnnonce ( Annonce annonce )
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "INSERT INTO annonce(prix , extra , descriptif, etat , type, titre, categorie , isVisible , isFini, vendeur) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"))
        {
            preparedStatement.setFloat(     1,  annonce.getPrix ());
            preparedStatement.setString(    2,  annonce.getExtra ());
            preparedStatement.setString(    3,  annonce.getDescriptif ());
            preparedStatement.setString(    4,  annonce.getEtat ());
            preparedStatement.setString(    5,  annonce.getType ());
            preparedStatement.setString(    6,  annonce.getTitre ());
            preparedStatement.setBoolean(   7,  annonce.isCategorie ());
            preparedStatement.setBoolean(   8,  annonce.isVisible ());
            preparedStatement.setBoolean(   9,  annonce.isFini ());
            preparedStatement.setInt(       10,  annonce.getVendeur ());

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
                     "UPDATE annonce SET idAnnonce=? , prix=? , extra=? , descriptif=?, etat=? , img=? , type=? , titre=? , categorie=? , isVisible=? , isFini=? , vendeur=? WHERE id=?;")){
            preparedStatement.setInt    (1, annonce.getIdAnnonce () );
            preparedStatement.setFloat  (2, annonce.getPrix ()      );
            preparedStatement.setString (3, annonce.getExtra ()     );
            preparedStatement.setString (4, annonce.getDescriptif ());
            preparedStatement.setString (5, annonce.getEtat ()      );
            preparedStatement.setString (6, annonce.getImg ()       );
            preparedStatement.setString (7, annonce.getType ()      );
            preparedStatement.setString (8, annonce.getTitre ()     );
            preparedStatement.setBoolean(9, annonce.isCategorie ()  );
            preparedStatement.setBoolean(10,annonce.isVisible ()    );
            preparedStatement.setBoolean(11,annonce.isFini ()       );
            preparedStatement.setInt    (12,annonce.getVendeur ()   );

            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Annonce recupAnnonce (String typeA,Boolean categorieA)
    {
        Annonce annonce = new Annonce ();
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT idAnnonce , prix , extra , descriptif, etat , titre, categorie , isVisible , isFini, vendeur FROM annonce WHERE categorie=='"+categorieA+"' AND type=='"+typeA+"';")) {
            while (resultat.next())
            {
                int idAnnonce       = resultat.getInt (     "idAnnonce"     );
                float prix          = resultat.getFloat (   "prix"          );
                String extra        = resultat.getString (  "extra"         );
                String descriptif   = resultat.getString (  "descriptif"    );
                boolean categorie   = resultat.getBoolean ( "categorie"     );
                boolean isVisible   = resultat.getBoolean ( "isVisible"     );
                boolean isFini      = resultat.getBoolean ( "isFini"        );
                int vendeur         = resultat.getInt (     "vendeur"       );
                String img          = resultat.getString (  "img"           );

                annonce.setIdAnnonce ( idAnnonce );
                annonce.setPrix ( prix );
                annonce.setExtra ( extra );
                annonce.setDescriptif ( descriptif );
                annonce.setCategorie ( categorie );
                annonce.setVisible ( isVisible );
                annonce.setFini ( isFini );
                annonce.setVendeur ( vendeur );
                annonce.setImg ( img );

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return annonce;
    }
}
