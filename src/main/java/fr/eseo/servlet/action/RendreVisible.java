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
        //--------------------------------------------------------------------
        /*Annonce annonce_sup =daoannonce.chercherAnnonceParId(5);
        daoannonce.suprimerAnnonce(annonce_sup);*/

        Annonce anonce_rendu_lisible =daoannonce.chercherAnnonceParId(8);
        anonce_rendu_lisible.setVisible(true);
        System.out.println(anonce_rendu_lisible.isVisible());
        daoannonce.modifierAnnonce(anonce_rendu_lisible);
        Annonce anonce_rendu_lisible2=daoannonce.chercherAnnonceParId(8);
        System.out.println(anonce_rendu_lisible2.isVisible());


        //--------------------------------------------------------------------

        List<Annonce> liste_annonce_a_valider = daoannonce.recupAnnonceVisible(false);
        List<Annonce> liste_annonce_autre = daoannonce.recupAnnonceVisible(true);
        request.setAttribute("a_valider", liste_annonce_a_valider);
        request.setAttribute("a_modif", liste_annonce_autre);


        forward(request, response, "jsp/page_modo_annonce.jsp");

        /*

        String lisible = request.getParameter("lisible");
        String supprimer = request.getParameter("supprimer");

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
