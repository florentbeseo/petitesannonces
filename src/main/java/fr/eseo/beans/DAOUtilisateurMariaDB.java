package fr.eseo.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUtilisateurMariaDB implements DAOUtilisateur {
    private final DAOFactory daoFactory;
    DAOUtilisateurMariaDB(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "INSERT INTO utilisateurs(address, prenom) VALUES(?, ?);")){
            preparedStatement.setString(1, utilisateur.getAddresse());
            preparedStatement.setString(2, utilisateur.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List <Utilisateur> listerUtilisateurs() {
        List<Utilisateur> annuaire = new ArrayList <> ();
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT nom, prenom FROM utilisateurs;")) {
            while (resultat.next()) {
                String addresse = resultat.getString("addresse");
                String password = resultat.getString("password");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setAddresse(addresse);
                utilisateur.setPassword(password);
                annuaire.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annuaire;
    }
}

