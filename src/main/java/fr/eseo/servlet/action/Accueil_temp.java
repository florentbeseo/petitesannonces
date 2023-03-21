package fr.eseo.servlet.action;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    Action qui renvoi vers la page d'accueil temporaire
    @author Georjon Théo
    @version 1.4
    @see Controller
 */
public class Accueil_temp implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {
        forward(request, response, "jsp/page_accueil_temporaire.jsp");
    }
}
