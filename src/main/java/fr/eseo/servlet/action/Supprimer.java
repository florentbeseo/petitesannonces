package fr.eseo.servlet.action;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Supprimer implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Utilisateur utilisateur = daoutilisateur.recupUtilisateur(session.getAttribute("mail").toString());
        System.out.println(session.getAttribute("mail"));

        daoutilisateur.suprimerUtilisateur(utilisateur);

        forward(request, response, "jsp/page_accueil_temporaire.jsp");
    }

}
