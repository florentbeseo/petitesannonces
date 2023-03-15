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
        float prix = Integer.parseInt(request.getParameter("prix"));
        String extra = request.getParameter("extra");
        String descriptif = request.getParameter("description");
        String etat = request.getParameter("etat");
        //Utilisateur utilisateur= new DAOUtilisateur();

        boolean catégorie = Boolean.parseBoolean(request.getParameter("categorie"));
        boolean visible = true;
        boolean fini = false;
        HttpSession session = request.getSession( true );
        if ( session.getAttribute("login") == null ) {
            session.setAttribute( "login", "" );
        }
        String mail= String.valueOf(request.getSession().getAttribute("mail"));
        Utilisateur utilisateur=daoutilisateur.recupUtilisateur(mail);
        int vendeur = utilisateur.getIdUtilisateur();

        System.out.println("1");
        Annonce annonce =new Annonce(prix , extra , descriptif , etat , vendeur , catégorie);
        System.out.println("2");

        daoannonce.ajouterAnnonce(annonce);
        System.out.println("3");

        //request.getParameter("Nu") != null && !request.getParameter("Nu").equals("")
    }
}
