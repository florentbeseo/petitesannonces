package fr.eseo.servlet.action;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
    Action qui permet de récupérer les infos d'un profil
    @author Georjon Théo
    @version 1.1
    @see Controller
 */
public class Profil implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur utilisateur = daoutilisateur.recupUtilisateur(session.getAttribute("mail").toString());

        session.setAttribute("nom", utilisateur.getNom());
        session.setAttribute("prenom", utilisateur.getPrenom());
        session.setAttribute("pseudo", utilisateur.getPseudo());
        session.setAttribute("mail", utilisateur.getAdresse());
        session.setAttribute("date", utilisateur.getAnniversaire());
        session.setAttribute("tel", utilisateur.getTel());
        session.setAttribute("mdp", utilisateur.getMdp());

        session.setAttribute("admin", utilisateur.isAdmin());

        forward(request, response, "jsp/page_profil.jsp");
    }
}
