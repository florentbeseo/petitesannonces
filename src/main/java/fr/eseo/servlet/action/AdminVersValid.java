package fr.eseo.servlet.action;

import fr.eseo.beans.Annonce;
import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminVersValid implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException
    {

        List<Annonce> liste_annonce_a_valider = daoannonce.recupAnnonceVisible(false);
        List<Annonce> liste_annonce_autre = daoannonce.recupAnnonceVisible(true);

        request.setAttribute("a_valider", liste_annonce_a_valider);
        request.setAttribute("a_modif", liste_annonce_autre);

        System.out.println(liste_annonce_a_valider);
        System.out.println(liste_annonce_autre);

        forward(request, response, "jsp/page_modo_annonces.jsp");
    }
}
