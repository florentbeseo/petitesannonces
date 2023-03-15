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
                     "INSERT INTO annonce(idAnnonce , prix , extra , descriptif, vendeur , categorie , isVisible , isFini) VALUES(?, ?, ?, ?, ?, ?, ?, ?);"))
        {
            preparedStatement.setString(1, Integer.toString ( annonce.getIdAnnonce () ) );
            preparedStatement.setString(2, Float.toString ( annonce.getPrix ()        ) );
            preparedStatement.setString(3, annonce.getExtra ()                          );
            preparedStatement.setString(4, annonce.getDescriptif ()                     );
            preparedStatement.setString(5, Integer.toString ( annonce.getVendeur ()   ) );
            preparedStatement.setString(6, Boolean.toString ( annonce.isCategorie ()  ) );
            preparedStatement.setString(7, Boolean.toString ( annonce.isVisible ()    ) );
            preparedStatement.setString(8, Boolean.toString ( annonce.isFini ()       ) );
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
                     "UPDATE annonce SET prix=? , extra=? , descriptif=?, vendeur=? , categorie=? , isVisible=? , isFini=? WHERE id=?;")){
            preparedStatement.setString(1, Float.toString ( annonce.getPrix ()       )  );
            preparedStatement.setString(2, annonce.getExtra (                        )  );
            preparedStatement.setString(3, annonce.getDescriptif (                   )  );
            preparedStatement.setString(4, Integer.toString ( annonce.getVendeur ()  )  );
            preparedStatement.setString(5, Boolean.toString ( annonce.isCategorie () )  );
            preparedStatement.setString(6, Boolean.toString ( annonce.isVisible ()   )  );
            preparedStatement.setString(7, Boolean.toString ( annonce.isFini ()      )  );
            preparedStatement.setString(8, Integer.toString ( annonce.getIdAnnonce ())  );
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
                     "SELECT idAnnonce, prix, extra, descriptif, categorie, isVisible, isFini, vendeur,img FROM annonce WHERE categorie=categorieA AND type=typeA;")) {
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

                annonce.setIdAnnonce (  idAnnonce );
                annonce.setPrix (       prix );
                annonce.setExtra (      extra );
                annonce.setDescriptif ( descriptif );
                annonce.setCategorie (  categorie );
                annonce.setVisible (    isVisible );
                annonce.setFini (       isFini );
                annonce.setVendeur (    vendeur );
                annonce.setImg (        img );

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return annonce;
    }
}
