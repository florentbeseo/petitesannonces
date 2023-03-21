package fr.eseo.servlet.action;

import fr.eseo.beans.Annonce;
import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RendreVisible implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException
    {
        Annonce annonce =daoannonce.chercherAnnonceParId(2);
        daoannonce.suprimerAnnonce(annonce);
        forward(request, response, "jsp/page_modo_annonce.jsp");
        /*
        String lisible = request.getParameter("lisible");
        System.out.println(lisible);
        String supprimer = request.getParameter("supprimer");
        System.out.println(supprimer);

        if(lisible!= null){
            Annonce annonce =daoannonce.chercherAnnonceParId(Integer.parseInt(lisible));
            annonce.setVisible(true);
            daoannonce.modifierAnnonce(annonce);
            forward(request, response, "jsp/page_modo_annonce.jsp");
        }
        else {
            Annonce annonce =daoannonce.chercherAnnonceParId(Integer.parseInt(supprimer));
            daoannonce.suprimerAnnonce(annonce);
            forward(request, response, "jsp/page_modo_annonce.jsp");

        }*/



    }
}
