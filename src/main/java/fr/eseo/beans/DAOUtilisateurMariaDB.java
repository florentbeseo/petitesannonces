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
                     "INSERT INTO utilisateurs(pseudo, mdp) VALUES(?, ?);")){
            preparedStatement.setString(1, utilisateur.getPseudo ());
            preparedStatement.setString(2, utilisateur.getMdp());
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
                String adresse = resultat.getString("adresse");
                String mdp = resultat.getString("mdp");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setAdresse(adresse);
                utilisateur.setMdp(mdp);
                annuaire.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annuaire;
    }
}

