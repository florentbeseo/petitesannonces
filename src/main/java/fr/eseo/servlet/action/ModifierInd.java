package fr.eseo.servlet.action;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ModifierInd implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Utilisateur utilisateur = daoutilisateur.recupUtilisateur(session.getAttribute("mail_selec").toString());

        request.setAttribute("modif_ind", true);
        request.setAttribute("ind", utilisateur.getInd());

        if (request.getParameter("indice") != null) {
            int ind = Integer.parseInt(request.getParameter("indice"));
            if (ind >= -10 && ind <= 10) {
                utilisateur.setInd(ind);
                daoutilisateur.modifierUtilisateur(utilisateur);
                request.setAttribute("modif_ind", true);
            }
            /*else {

            }*/
        }

        forward(request, response, "jsp/page_profil.jsp");
    }
}