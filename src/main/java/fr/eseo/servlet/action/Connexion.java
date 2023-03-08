package fr.eseo.servlet.action;

import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Connexion implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur) throws ServletException, IOException {
        if(request.getParameter("Nu") != null && !request.getParameter("Nu").equals("")) {
            forward(request,response,"jsp/index.jsp");
        }
        forward(request,response,"jsp/page_connection.jsp");

        /*boolean isFirstConnection = false;
        if(request.getSession().getAttribute("isFirstConnection") == null) {
            isFirstConnection = true;
            HttpSession session = request.getSession( true );
            session.setAttribute( "firstConnection", false );
        }

        String utilisaeur = request.getParameter("Nu");
        String motPasse = request.getParameter("Mdp");
        //boolean isLogin = daoutilisateur.recupUtilisateur(utilisaeur,motPasse);
        if(isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute( "user", utilisaeur );
            forward(request,response,"jsp/index.jsp");
        } else {
            //if(!isFirstConnection) {                request.setAttribute("error", true);            }
            forward(request, response, "jsp/page_aide.jsp");
        }*/
    }
}
