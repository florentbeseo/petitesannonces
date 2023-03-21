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
    Action qui permet l'affichage des annonces
    @author Birmeleboutin Florent
    @version 1.4
    @see Controller
 */
public class Afficher_annonce implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException
    {

        /*List<Annonce> liste_annonce_modif=new ArrayList<>();

        for (int i=0; i<10; i++){
            Annonce annonce=new Annonce(10, "objet", "nouveau", "casse", "img", "véhicule", "voiture",false,i+4);
            liste_annonce_modif.add(annonce);
        }*/
        Annonce annonce=new Annonce(10, "objet", "nouveau", "casse", "img", "véhicule", "voiture",false,4);
        System.out.println(annonce.getTitre());
        String titre = annonce.getTitre();
        forward(request, response, "jsp/page_modo_annonce.jsp");
    }
}

