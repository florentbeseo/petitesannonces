package fr.eseo.servlet.action;

import fr.eseo.beans.Annonce;
import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Accueil_Biens implements Action
{
    @Override
    public void execute( HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException
    {

        List<Annonce> liste_annonce = daoannonce.recupAnnonceCat(false);

        request.setAttribute("test", liste_annonce);

        forward(request, response, "jsp/page_accueil_biens.jsp");
    }
}
