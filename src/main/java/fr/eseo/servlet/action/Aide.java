package fr.eseo.servlet.action;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    Action qui renvoi vers la page d'aide
    @author Amiaud Antoine
    @version 1.0
    @see Controller
 */
public class Aide implements Action
{
    @Override
    public void execute( HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException
    {
        forward(request, response, "jsp/page_aide.jsp");
    }
}
