package fr.eseo.beans;

import java.util.List;

public interface DAOUtilisateur
{
    void ajouterUtilisateur(Utilisateur utilisateur);

    List <Utilisateur> listerUtilisateurs ();
}
