package fr.eseo.servlet.action;

import fr.eseo.beans.Annonce;
import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
    Action qui permet de rendre visible ou non une annonce
    @author Birmeleboutin Florent
    @version 1.3
    @see Controller
 */
public class RendreVisible implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException
    {
        List<Annonce> liste_annonce_a_valider = daoannonce.recupAnnonceVisible(false);
        List<Annonce> liste_annonce_autre = daoannonce.recupAnnonceVisible(true);
        request.setAttribute("a_valider", liste_annonce_a_valider);
        request.setAttribute("a_modif", liste_annonce_autre);


        forward(request, response, "jsp/page_modo_annonce.jsp");

        String lisible = request.getParameter("lisible");
        String supprimer = request.getParameter("supprimer");

        if(lisible!= null){
            Annonce annonce =daoannonce.chercherAnnonceParId(Integer.parseInt(lisible));
            System.out.println(annonce.getIdAnnonce());
            annonce.setVisible(true);
            daoannonce.modifierAnnonce(annonce);
            forward(request, response, "jsp/page_modo_annonce.jsp");
        }
        else {
            Annonce annonce =daoannonce.chercherAnnonceParId(Integer.parseInt(supprimer));
            daoannonce.suprimerAnnonce(annonce);
            forward(request, response, "jsp/page_modo_annonce.jsp");

        }



    }
}
