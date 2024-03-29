package fr.eseo.servlet;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOFactory;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.servlet.action.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/*
    Le controller permet la navigation entre les différentes pages du site et la transmission des données
    @author Georjon Théo
    @version 1.9
 */
@WebServlet(name = "Controller", value = "/Controller")
public class  Controller extends HttpServlet {

    private final Map<String, Action> actionMap = new HashMap<>();
    private DAOUtilisateur daoutilisateur;
    private DAOAnnonce daoannonce;

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoutilisateur = daoFactory.getUtilisateurDao("MariaDB");
        daoannonce = daoFactory.getAnnonceDao("MariaDB");
        actionMap.put("connection",                     new Connection ());
        actionMap.put("inscription",                    new Inscription());
        actionMap.put("creation_annonce",               new Creation_Annonce());
        actionMap.put("profile",                        new Profil());
        actionMap.put("aide",                           new Aide());
        actionMap.put("accueil_biens",                  new Accueil_Biens ());
        actionMap.put("accueil_services",               new Accueil_Services ());
        actionMap.put("accueil",                        new Accueil());
        actionMap.put("accueil_temp",                   new Accueil_temp());
        actionMap.put("modification",                   new Modification());
        actionMap.put("nouvelle_annonce",               new NouvelleAnnonce());
        actionMap.put("supprimer",                      new Supprimer());
        actionMap.put("modification_admin",             new DroitAdmin());
        actionMap.put("bloquer_admin",                  new BloquerAdmin());
        actionMap.put("bloquer_compte",                 new Bloquer());
        actionMap.put("creer_compte",                   new CreerCompte());
        actionMap.put("deconnexion",                    new Deconnexion());
        actionMap.put("modifier_indice_satisfaction",   new ModifierInd());
        actionMap.put("afficher_annonce",               new Afficher_annonce());
        actionMap.put("admin_vers_valid_annonce",       new AdminVersValid());
        actionMap.put("rendre_visible",                 new RendreVisible());
        actionMap.put("mes_annonces",                   new Mes_Annonces());
        actionMap.put("debloquer_compte",               new Debloquer());
        actionMap.put("voir_annonce",                   new SimpleAnnonce());
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
            id="accueil";
        }
        Action action = actionMap.get(id);
        if(action != null) {
            action.execute(request, response, daoutilisateur, daoannonce);
        } else {
            new Exception();
        }
    }
}
