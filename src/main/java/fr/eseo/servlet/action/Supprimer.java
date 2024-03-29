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
    Action qui permet de supprimer un utilisateur de la base de données
    @author Georjon Théo
    @version 1.1
    @see Controller
 */
public class Supprimer implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        HttpSession session = request.getSession();


        if(session.getAttribute("mail_selec") != null){
            Utilisateur utilisateur = daoutilisateur.recupUtilisateur(session.getAttribute("mail_selec").toString());
            daoutilisateur.suprimerUtilisateur(utilisateur);
        }
        else{
            Utilisateur utilisateur = daoutilisateur.recupUtilisateur(session.getAttribute("mail").toString());
            session.setAttribute("pseudo", "");
            daoutilisateur.suprimerUtilisateur(utilisateur);
        }

        forward(request, response, "jsp/page_acceuil.jsp");
    }

}
