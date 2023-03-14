package fr.eseo.servlet.action;

import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Profil implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur) throws ServletException, IOException {

        Utilisateur utilisateur = daoutilisateur.recupUtilisateur("theo.georjon@reseau.eseo.fr", "root123");

        HttpSession session = request.getSession();

        session.setAttribute("nom", utilisateur.getNom());
        System.out.println("Nom: "+utilisateur.getNom());

        forward(request, response, "jsp/page_profil.jsp");
    }
}
