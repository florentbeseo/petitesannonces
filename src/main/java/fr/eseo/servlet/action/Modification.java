package fr.eseo.servlet.action;

import fr.eseo.beans.DAOAnnonce;
import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Integer.*;

public class Modification implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur, DAOAnnonce daoannonce) throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pseudo = request.getParameter("pseudo");
        String mail = request.getParameter("mail");
        String anniversaire = request.getParameter("date");
        String telephone = request.getParameter("telephone");
        String mdp = request.getParameter("mdp");

        List<Utilisateur> liste_utilisateur = daoutilisateur.listerUtilisateurs();

        HttpSession session = request.getSession();
        Utilisateur utilisateur = daoutilisateur.recupUtilisateur(session.getAttribute("mail").toString());

        if(nom != null && !nom.equals("")){
            utilisateur.setNom(nom);
            System.out.println("Nom de l'utilisateur: "+utilisateur.getNom());
        }
        /*if (prenom != null && !prenom.equals("")) {
            est_rempli = true;
            utilisateur.setPrenom(prenom);
            System.out.println("Prenom de l'utilisateur: "+utilisateur.getPrenom());
        }
        if (pseudo != null && !pseudo.equals("")) {
            est_rempli = true;
            utilisateur.setPseudo(pseudo);
            System.out.println("Pseudo de l'utilisateur: "+utilisateur.getPseudo());
        }
        if (mail != null && !mail.equals("")) {
            est_rempli = true;
            boolean etat_mail = verification_mail(mail, request, liste_utilisateur);
            if(etat_mail == true){
                utilisateur.setAdresse(mail);
                System.out.println("Adresse de l'utilisateur: "+utilisateur.getAdresse());
            }
        }
        if (anniversaire != null && !anniversaire.equals("")) {
            est_rempli = true;
            Date anniversaire_reel = Date.valueOf(anniversaire);
            boolean etat_age = verification_age(anniversaire, request);
            if(etat_age == true){
                utilisateur.setAnniversaire(anniversaire_reel);
                System.out.println("Anniversaire de l'utilisateur: "+utilisateur.getAnniversaire());
            }
        }
        if (telephone != null && !telephone.equals("")) {
            est_rempli = true;
            boolean etat_telephone = verificattion_telephone(telephone, request);
            if(etat_telephone == true){
                utilisateur.setTel(telephone);
                System.out.println("Telephone de l'utilisateur: "+utilisateur.getTel());
            }
        }
        if (mdp != null && !mdp.equals("")) {
            est_rempli = true;
            utilisateur.setMdp(mdp);
            System.out.println("MDP de l'utilisateur: "+utilisateur.getMdp());
        }*/

        if (request.getParameter("log") != null) {
            daoutilisateur.modifierUtilisateur(utilisateur);
            forward(request, response, "jsp/page_profil.jsp");
        }

        forward(request,response,"jsp/page_modification.jsp"); // a modifier lorsque la page d'acceuil sera faite
    }

    private boolean verification_age(String date_naissance, HttpServletRequest request){

        boolean etat_age=false;

        String[] parts = date_naissance.split("-");
        int annee = parseInt(parts[0]);
        if (annee <= 2005) {
            etat_age = true;
        }
        else{
            request.setAttribute("Age_error", true);
        }

        return etat_age;
    }

    private boolean verification_mail(String mail, HttpServletRequest request, List<Utilisateur>liste_utilisateur){

        boolean etat_mail = true;

        for (int i=0; i<liste_utilisateur.size(); i++){
            if(liste_utilisateur.get(i).getAdresse().equals(mail)){
                etat_mail = false;
            }
        }

        if(etat_mail == false){
            request.setAttribute("Mail_error", true);
        }

        return etat_mail;
    }

    private boolean verificattion_telephone (String telephone, HttpServletRequest request){

        boolean etat_telephone = false;

        int nombre_telephone = telephone.length();

        try
        {
            int transformation = Integer.parseInt(telephone);
            if(nombre_telephone == 10) etat_telephone = true;
        }
        catch (NumberFormatException e)
        {
            request.setAttribute("Telephone_error", true);
            e.printStackTrace();
        }

        return etat_telephone;
    }

}
