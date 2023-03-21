package fr.eseo.servlet.action;

import fr.eseo.beans.Annonce;
import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Accueil_Services implements Action
{
    @Override
    public void execute( HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException
    {

        List<Annonce> liste_annonceCat = daoannonce.recupAnnonceCat(true);
        List<Annonce> liste_annonce = recupVisible(true, liste_annonceCat);
        System.out.println("taille: "+liste_annonce.size());

        String objet_recherche = request.getParameter("recherche");
        if(objet_recherche != null && !objet_recherche.equals("")){
            if(recherche_annonce(objet_recherche, liste_annonce)){
                List<Annonce> liste_titre = recupTitre(objet_recherche, liste_annonce);
                request.setAttribute("liste_annonce", liste_titre);
            }
        }

        List<Annonce> liste_trier;
        String selec = request.getParameter("selec");
        if(request.getParameter("selec") != null) {
            if (selec.equals("vehicule")) {
                liste_trier = recupType(liste_annonce, "Vehicule");
                request.setAttribute("liste_annonce", liste_trier);
            }
            else if (selec.equals("mobilier")) {
                liste_trier = recupType(liste_annonce, "Mobilier");
                request.setAttribute("liste_annonce", liste_trier);
            }
            else if (selec.equals("loisir")) {
                liste_trier = recupType(liste_annonce, "Loisir");
                request.setAttribute("liste_annonce", liste_trier);
            }
            else if (selec.equals("sport")) {
                liste_trier = recupType(liste_annonce, "Sport");
                request.setAttribute("liste_annonce", liste_trier);
            }
            else if (selec.equals("exterieur")) {
                liste_trier = recupType(liste_annonce, "Exterieur");
                request.setAttribute("liste_annonce", liste_trier);
            }
            else if (selec.equals("animalier")) {
                liste_trier = recupType(liste_annonce, "Animalier");
                request.setAttribute("liste_annonce", liste_trier);
            }
            else if (selec.equals("numerique")) {
                liste_trier = recupType(liste_annonce, "Numerique");
                request.setAttribute("liste_annonce", liste_trier);
            }
            else if (selec.equals("travail")) {
                liste_trier = recupType(liste_annonce, "Travail");
                request.setAttribute("liste_annonce", liste_trier);
            }
        }
        else{
            request.setAttribute("liste_annonce", liste_annonce);
        }

        forward(request, response, "jsp/page_accueil_services.jsp");
    }


    private List<Annonce> recupType (List<Annonce> liste_annonce, String type){
        List<Annonce> liste_filtrer = new ArrayList<>();
        Annonce annonce;

        for (int i=0; i<liste_annonce.size(); i++){
            annonce = liste_annonce.get(i);
            if(annonce.getType().equals(type)) liste_filtrer.add(annonce);
        }

        return liste_filtrer;
    }

    private boolean recherche_annonce(String recherche, List<Annonce> liste_annonce){

        boolean trouve = false;
        String titre = "";

        for(int i=0; i<liste_annonce.size(); i++){
            titre = liste_annonce.get(i).getTitre();
            if(titre.equals(recherche)){
                trouve = true;
            }
        }

        return trouve;
    }

    private List<Annonce> recupTitre (String titre, List<Annonce> liste_annonce){
        List<Annonce> liste_titre = new ArrayList<>();
        Annonce annonce;

        for (int i=0; i<liste_annonce.size(); i++){
            annonce = liste_annonce.get(i);
            if(annonce.getTitre().equals(titre)){
                liste_titre.add(annonce);
            }
        }

        return liste_titre;
    }

    private List<Annonce> recupVisible (Boolean isVisible, List<Annonce> liste_annonce){

        List<Annonce> liste_visible = new ArrayList<>();
        Annonce annonce;

        for (int i=0; i<liste_annonce.size(); i++){
            annonce = liste_annonce.get(i);
            if(annonce.isVisible() == isVisible){
                liste_visible.add(annonce);
            }
        }

        return liste_visible;
    }
}

