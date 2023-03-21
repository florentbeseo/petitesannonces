package fr.eseo.servlet.action;

import fr.eseo.beans.Annonce;
import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
    Action qui permet de récupérer les annonces publiées par un utilisateur
    @author Georjon Théo
    @version 1.1
    @see Controller
 */
public class Mes_Annonces implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String mail = session.getAttribute("mail").toString();
        Utilisateur utilisateur = daoutilisateur.recupUtilisateur(mail);

        List<Annonce> liste_annonce = daoannonce.recupAnnonceTout ();
        List<Annonce> liste_filtrer = recupMes_annonce(liste_annonce, utilisateur.getIdUtilisateur());


        request.setAttribute("liste_annonce", liste_filtrer);

        forward(request, response, "jsp/page_mes_annonces.jsp");
    }
    
    private List<Annonce> recupMes_annonce (List<Annonce> liste_annonce, Integer vendeur){
        List<Annonce> liste_filtrer = new ArrayList<>();
        Annonce annonce;

        for (int i=0; i<liste_annonce.size(); i++){
            annonce = liste_annonce.get(i);
            if(annonce.getVendeur() == vendeur){
                liste_filtrer.add(annonce);
            }
        }

        return liste_filtrer;
    }
}
