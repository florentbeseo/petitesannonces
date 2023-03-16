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

public class Connection implements Action
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException
    {

        String mail = request.getParameter("Nu");
        String mdp = request.getParameter("Mdp");
        List<Utilisateur> liste_utilisateur = daoutilisateur.listerUtilisateurs();

        if(request.getParameter("Nu") != null && !request.getParameter("Nu").equals(""))
        {
            if(request.getParameter("Mdp") != null && !request.getParameter("Mdp").equals(""))
            {
                boolean etat = verification(mdp, mail, request, liste_utilisateur);
                if (etat == true)
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("mail", mail);
                    forward(request, response, "jsp/page_acceuil.jsp");
                }
            }
            else{
                request.setAttribute("error", true);
            }
        }

        forward(request,response,"jsp/page_connection.jsp");
    }

    private boolean verification(String mdp, String mail, HttpServletRequest request, List<Utilisateur>liste_utilisateur){

        boolean etat = false;

        for (int i=0; i<liste_utilisateur.size(); i++){
            if(liste_utilisateur.get(i).getAdresse().equals(mail)){
                if(liste_utilisateur.get(i).getMdp().equals(mdp)){
                    etat = true;
                }
            }
        }

        if(etat == false){
            request.setAttribute("M_error", true);
        }

        return etat;
    }

}
