package fr.eseo.servlet.action;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
/*
    Action qui permet de rajouter des droits d'admin à un utilisateur
    @author Georjon Théo
    @version 1.1
    @see Controller
 */
public class DroitAdmin implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String objet_recherche = request.getParameter("recherche");
        if(objet_recherche != null && !objet_recherche.equals("")){
            if(recherche_utilisateur(objet_recherche, daoutilisateur)){
                Utilisateur utilisateur = daoutilisateur.recupUtilisateur(objet_recherche);
                request.setAttribute("admin_utilisateur", true);
                session.setAttribute("mail_selec", objet_recherche);
                request.setAttribute("bloque_admin", utilisateur.isAdmin());
                request.setAttribute("isBloque", utilisateur.isBloque());
            }
        }

        forward(request, response, "jsp/page_profil.jsp");
    }



    private boolean recherche_utilisateur(String recherche, DAOUtilisateur daoUtilisateur){

        List<Utilisateur> liste_utilisateur = daoUtilisateur.listerUtilisateurs();
        boolean trouve = false;
        String mail = "";

        for(int i=0; i<liste_utilisateur.size(); i++){
            mail = liste_utilisateur.get(i).getAdresse();
            if(mail.equals(recherche)){
                trouve = true;
            }
        }

        return trouve;
    }
}
