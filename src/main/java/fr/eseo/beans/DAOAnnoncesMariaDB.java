package fr.eseo.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DAOAnnoncesMariaDB implements DAOAnnonce
{
    private final DAOFactory daoFactory;
    DAOAnnoncesMariaDB(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public void ajouterAnnonce ( Annonce annonce )
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "INSERT INTO annonce(idAnnonce , prix , extra , descriptif, vendeur , categorie , isVisible , isFini) VALUES(?, ?, ?, ?, ?, ?, ?, ?);"))
        {
            preparedStatement.setString(1, Integer.toString ( annonce.getIdAnnonce () ));
            preparedStatement.setString(2, Float.toString ( annonce.getPrix () ));
            preparedStatement.setString(3, annonce.getExtra ());
            preparedStatement.setString(4, annonce.getDescriptif ());
            preparedStatement.setString(5, Integer.toString ( annonce.getVendeur () ));
            preparedStatement.setString(6, Boolean.toString ( annonce.isCategorie () ));
            preparedStatement.setString(7, Boolean.toString ( annonce.isVisible () ));
            preparedStatement.setString(8, Boolean.toString ( annonce.isFini () ));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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
            preparedStatement.setString(1, Float.toString ( annonce.getPrix () ));
            preparedStatement.setString(2, annonce.getExtra ());
            preparedStatement.setString(3, annonce.getDescriptif ());
            preparedStatement.setString(4, Integer.toString ( annonce.getVendeur () ));
            preparedStatement.setString(5, Boolean.toString ( annonce.isCategorie () ));
            preparedStatement.setString(6, Boolean.toString ( annonce.isVisible () ));
            preparedStatement.setString(7, Boolean.toString ( annonce.isFini () ));
            preparedStatement.setString(8, Integer.toString ( annonce.getIdAnnonce () ));
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
