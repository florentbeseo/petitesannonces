package fr.eseo.servlet.action;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SuppressionAdmin implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Object mail_selec = session.getAttribute("mail_selec");
        if(mail_selec != null){
            Utilisateur utilisateur = daoutilisateur.recupUtilisateur(mail_selec.toString());
            daoutilisateur.suprimerUtilisateur(utilisateur);
        }

        session.setAttribute("admin_utilisateur", false);

        forward(request, response, "jsp/page_profil.jsp");
    }
}
