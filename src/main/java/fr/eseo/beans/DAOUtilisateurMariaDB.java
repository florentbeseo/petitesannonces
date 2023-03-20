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
    public void ajouterUtilisateur(Utilisateur utilisateur)
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "INSERT INTO utilisateur(ind, pseudo,adresse,mdp,nom,prenom,anniversaire,tel,isAdmin,isBloque) VALUES(?,?,?,?,?,?,?,?,?,?);"))
        {
            preparedStatement.setInt(       1,  utilisateur.getInd ()               );
            preparedStatement.setString(    2,  utilisateur.getPseudo ()            );
            preparedStatement.setString(    3,  utilisateur.getAdresse ()           );
            preparedStatement.setString(    4,  utilisateur.getMdp ()               );
            preparedStatement.setString(    5,  utilisateur.getNom ()               );
            preparedStatement.setString(    6,  utilisateur.getPrenom ()            );
            preparedStatement.setDate(      7,  utilisateur.getAnniversaire ()      );
            preparedStatement.setString(    8,  utilisateur.getTel ()               );
            preparedStatement.setBoolean(   9,  utilisateur.isAdmin()               );
            preparedStatement.setBoolean(   10, utilisateur.isBloque()              );
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
                     "DELETE FROM utilisateur WHERE adresse = ?;"))
        {
            preparedStatement.setString(1, utilisateur.getAdresse ());
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierUtilisateur ( Utilisateur utilisateur )
    {
        try (Connection connexion = daoFactory.getConnection() ;
             PreparedStatement preparedStatement = connexion.prepareStatement(
                     "UPDATE utilisateur SET nom=?, prenom=?, adresse=?, tel=?, pseudo=?, isBloque=?, isAdmin=?, ind=? WHERE idUtilisateur=?;")){
            preparedStatement.setString(    1,  utilisateur.getNom ()                               );
            preparedStatement.setString(    2,  utilisateur.getPrenom ()                            );
            preparedStatement.setString(    3,  utilisateur.getAdresse ()                           );
            preparedStatement.setString(    4,  utilisateur.getTel ()                               );
            preparedStatement.setString(    5,  utilisateur.getPseudo ()                            );
            preparedStatement.setBoolean(   6,  utilisateur.isBloque()                              );
            preparedStatement.setBoolean(   7,  utilisateur.isAdmin()                               );
            preparedStatement.setString(    8,  Integer.toString ( utilisateur.getInd ())           );
            preparedStatement.setString(    9,  Integer.toString ( utilisateur.getIdUtilisateur ()) );
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateur recupUtilisateur ( String adresseU)
    {
        Utilisateur utilisateur = new Utilisateur (  );
        try (Connection connexion = daoFactory.getConnection() ;
             Statement statement = connexion.createStatement() ;
             ResultSet resultat = statement.executeQuery(
                     "SELECT idUtilisateur, ind, nom, prenom, tel, pseudo, anniversaire,isAdmin,isBloque, adresse, mdp FROM utilisateur WHERE adresse ='"+adresseU+"' ;")) {
            while (resultat.next())
            {
                int idUtilisateur = resultat.getInt ("idUtilisateur");
                int ind = resultat.getInt ("ind");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String pseudo = resultat.getString("pseudo");
                Date anniversaire = resultat.getDate("anniversaire");
                boolean isAdmin = resultat.getBoolean("isAdmin");
                boolean isBloque = resultat.getBoolean ("isBloque");
                String tel = resultat.getString("tel");
                String adresse = resultat.getString( "adresse");
                String mdp = resultat.getString( "mdp");
                utilisateur.setNom ( nom );
                utilisateur.setInd ( ind );
                utilisateur.setPrenom ( prenom );
                utilisateur.setIdUtilisateur ( idUtilisateur );
                utilisateur.setPseudo ( pseudo );
                utilisateur.setAnniversaire ( anniversaire );
                utilisateur.setAdmin ( isAdmin );
                utilisateur.setBloque (isBloque);
                utilisateur.setTel (tel);
                utilisateur.setAdresse( adresse );
                utilisateur.setMdp( mdp );
            }
        } catch (SQLException e)
        {
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
                     "SELECT adresse, mdp FROM utilisateur;"))
        {
            while (resultat.next())
            {
                String adresse = resultat.getString("adresse");
                String mdp = resultat.getString("mdp");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setAdresse(adresse);
                utilisateur.setMdp(mdp);
                annuaire.add(utilisateur);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return annuaire;
    }
}

