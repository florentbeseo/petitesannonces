package fr.eseo.servlet.action;

import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Accueil_Services implements Action
{
    @Override
    public void execute( HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur) throws ServletException, IOException
    {
        forward(request, response, "jsp/page_accueil_services.jsp");
    }
}
