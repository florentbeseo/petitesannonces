package fr.eseo.servlet.action;

import fr.eseo.beans.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NouvelleAnnonce implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        //float prix = Float.parseFloat(request.getParameter("prix"));     //attention probleme de transcipage
        String extra = request.getParameter("extra");
        String descriptif = request.getParameter("description");
        String etat = request.getParameter("etat");
        //Utilisateur utilisateur= new DAOUtilisateur();

        boolean categorie = Boolean.parseBoolean(request.getParameter("categorie"));
        boolean visible = true;
        boolean fini = false;
        HttpSession session = request.getSession();
        /*if (session.getAttribute("login") == null) {              existe pas de login dans la session ni dans les request de page_creation_annonce
            session.setAttribute("login", "");
        }*/
        String mail = String.valueOf(request.getSession().getAttribute("mail"));
        Utilisateur utilisateur = daoutilisateur.recupUtilisateur(mail);
        int vendeur = utilisateur.getIdUtilisateur();

        System.out.println("1");
        //Annonce annonce = new Annonce(prix, extra, descriptif, etat, vendeur, categorie);
        System.out.println("2");

        if (request.getParameter("log") != null) {
            Annonce annonce = new Annonce(205.5F, "test_extra", "descriptif_test", "etat_test", 2, true);
            daoannonce.ajouterAnnonce(annonce);    //avec ce test on voit qu'il ya un souci dans l'écriture de la base de donnee
        }
        System.out.println("3");

        //request.getParameter("Nu") != null && !request.getParameter("Nu").equals("")

        forward(request, response, "jsp/page_creation_annonce.jsp");
    }
}
