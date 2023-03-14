package fr.eseo.servlet.action;

import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Profil implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String mail = "test";
        String mdp = "test";

        Utilisateur utilisateur = daoutilisateur.recupUtilisateur(mail, mdp);

        String nom = utilisateur.getNom();
        String prenom = utilisateur.getPrenom();
        String pseudo = utilisateur.getPseudo();
        java.sql.Date date_naissance = utilisateur.getAnniversaire();
        String telephone = utilisateur.getTel();

        session.setAttribute("nom", mail);


        forward(request, response, "jsp/page_profil.jsp");
    }
}
