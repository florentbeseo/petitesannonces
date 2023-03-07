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
    public void suprimerUtilisateur ( Utilisateur utilisateur )
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "DELETE FROM utilisateurs WHERE adresse = ?;")){
            preparedStatement.setString(1, utilisateur.getAdresse ());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierUtilisateur ( Utilisateur utilisateur )
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "UPDATE utilisateurs SET nom=?, prenom=?, adresse=?, tel=? WHERE id=?;")){
            preparedStatement.setString(1, utilisateur.getNom ());
            preparedStatement.setString(2, utilisateur.getPrenom ());
            preparedStatement.setString(3, utilisateur.getAdresse ());
            preparedStatement.setString(4, utilisateur.getTel ());
            preparedStatement.setString(5, Integer.toString ( utilisateur.getIdUtilisateur ()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateur recupUtilisateur ( String adresseU, String mdpU )
    {
        Utilisateur utilisateur = new Utilisateur (  );
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT idUtilisateur,nom, prenom, tel, pseudo, anniversasire,isAdmin,isBloque FROM utilisateurs WHERE adresse = adresseU AND mdp = mdpU;")) {
            while (resultat.next()) {
                int idUtilisateur = resultat.getInt ("idUtilisateur");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String pseudo = resultat.getString("pseudo");
                String anniversasire = resultat.getString("anniversasire");
                boolean isAdmin = resultat.getBoolean("isAdmin");
                boolean isBloque = resultat.getBoolean ("isBloque");
                String tel = resultat.getString("tel");
                utilisateur.setNom ( nom );
                utilisateur.setPrenom ( prenom );
                utilisateur.setIdUtilisateur ( idUtilisateur );
                utilisateur.setPseudo ( pseudo );
                utilisateur.setAnniversaire ( anniversasire );
                utilisateur.setAdmin ( isAdmin );
                utilisateur.setBloque (isBloque);
                utilisateur.setTel (tel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }


    @Override
    public List <Utilisateur> listerUtilisateurs ( ) {
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

