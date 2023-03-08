package fr.eseo.servlet;

import fr.eseo.beans.DAOFactory;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.servlet.action.Action;
import fr.eseo.servlet.action.Connexion;
import fr.eseo.servlet.action.Inscription;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Controller", value = "/Controller")
public class  Controller extends HttpServlet {

    private final Map<String, Action> actionMap = new HashMap<>();
    private DAOUtilisateur daoutilisateur;

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoutilisateur = daoFactory.getUtilisateurDao("MariaDB");
        actionMap.put("connection", new Connexion());
        actionMap.put("inscription", new Inscription());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        if(id == null) {
            id="connection";
        }
        Action action = actionMap.get(id);
        if(action != null) {
            action.execute(request, response, daoutilisateur);
        } else {
            new Exception();
        }
    }
}
