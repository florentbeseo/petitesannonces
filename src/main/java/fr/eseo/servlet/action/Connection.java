package fr.eseo.servlet.action;

import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class                                                                                                                                                                                                                                                                                                                                                                    Connection implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur) throws ServletException, IOException {

        String Pseudo_utilisateur = request.getParameter("Nu");
        String motPasse = request.getParameter("Mdp");
        List<Utilisateur> liste_utilisateur = daoutilisateur.listerUtilisateurs();

        for (int j=0; j<liste_utilisateur.size(); j++){
            System.out.println("Pour le bougue "+j+" le pseudo est: "+liste_utilisateur.get(j).getPseudo());
        }

        boolean existe = true;
        //boolean champ_rempli = false;
        if(request.getParameter("Nu") != null && !request.getParameter("Nu").equals("")) {
            if(request.getParameter("Mdp") != null && !request.getParameter("Mdp").equals("")) {
                for (int i = 0; i < liste_utilisateur.size(); i++) {
                    if (liste_utilisateur.get(i).getPseudo() == Pseudo_utilisateur) {
                        if (liste_utilisateur.get(i).getMdp() == motPasse) {
                            existe = true;
                        }
                    }
                }
                if (existe == true) {
                    HttpSession session = request.getSession();
                    session.setAttribute("pseudo", Pseudo_utilisateur);
                    forward(request, response, "jsp/page_profil.jsp");
                }
            }
            else{
                request.setAttribute("Mdp_error", true);
            }
        }
        /*else {
            request.setAttribute("Mdp_error", true);  //piste pour apres avoir regler le proleme du double lancement
        }*/


        /*boolean existe = false;
        if(champ_rempli == true) {
            for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i).getPseudo() == Pseudo_utilisateur) {
                    if (liste.get(i).getMdp() == motPasse) {
                        existe = true;
                    }
                }                                                               //piste pour apres avoir regler le proleme du double lancement
            }
            if (existe == true) {
                HttpSession session = request.getSession();
                session.setAttribute("user", Pseudo_utilisateur);
                forward(request, response, "jsp/page_profil.jsp");
            }
        }
        else{
            request.setAttribute("Mdp_error", true);
        }*/

        forward(request,response,"jsp/page_connection.jsp");
    }
}
