package fr.eseo.servlet.action;

import fr.eseo.beans.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
    Action qui permet de créer une annonce
    @author Georjon Théo
    @version 1.1
    @see Controller
 */
public class NouvelleAnnonce implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        float prix = Float.parseFloat(request.getParameter("prix"));     //attention probleme de transcipage
        String extra = request.getParameter("extra");
        String descriptif = request.getParameter("description");
        String etat = request.getParameter("etat");
        String img = request.getParameter("img");
        String type = request.getParameter("type");

        HttpSession session = request.getSession();
        String mail = session.getAttribute("mail").toString();

        Utilisateur utilisateur = daoutilisateur.recupUtilisateur(mail);
        int vendeur = utilisateur.getIdUtilisateur();

        boolean categorie = Boolean.parseBoolean(request.getParameter("categorie"));


        Annonce annonce = new Annonce(prix, extra, descriptif, etat, img, type, titre, categorie, vendeur);
        daoannonce.ajouterAnnonce(annonce);

        List<Annonce> liste_annonce = daoannonce.recupAnnonceTout();
        List<Annonce> listeDerniere_annonce = new ArrayList<>();
        request.setAttribute("liste_annonce", listeDerniere_annonce);

        forward(request, response, "jsp/page_creation_annonce.jsp");
    }

}
