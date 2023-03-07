package fr.eseo.beans;

import java.util.List;

public interface DAOUtilisateur
{
    void ajouterUtilisateur(Utilisateur utilisateur);
    void suprimerUtilisateur(Utilisateur utilisateur);
    void modifierUtilisateur(Utilisateur utilisateur);
    Utilisateur recupUtilisateur(String adresse,String mdp);

    List <Utilisateur> listerUtilisateurs ();
}
