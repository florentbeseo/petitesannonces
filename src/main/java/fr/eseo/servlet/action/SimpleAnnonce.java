package fr.eseo.servlet.action;

import fr.eseo.beans.Annonce;
import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SimpleAnnonce implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        List<Annonce> liste_annonce = daoannonce.recupAnnonceTout();

        HttpSession session = request.getSession();
        Object preTest = session.getAttribute("titre");
        if(preTest != null) {
            String test = preTest.toString();
            System.out.println("test: " + test);
        }

        forward(request, response, "jsp/page_annonce.jsp");
    }
}
