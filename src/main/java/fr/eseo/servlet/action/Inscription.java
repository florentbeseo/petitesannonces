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

public class Inscription implements Action{
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

        if(nom != null && !nom.equals(""))
        {
            if(prenom != null && !prenom.equals(""))
            {
                if(pseudo != null && !pseudo.equals(""))
                {
                    if(mail != null && !mail.equals(""))
                    {
                        if(anniversaire != null && !anniversaire.equals(""))
                        {
                            Date anniversaire_reel = Date.valueOf(anniversaire);
                            if(telephone != null && !telephone.equals(""))
                            {
                                if(mdp != null && !mdp.equals(""))
                                {
                                    boolean etat_age = verification_age(anniversaire, request);
                                    boolean etat_telephone = verificattion_telephone(telephone, request);
                                    boolean etat_mail = verification_mail(mail, request, liste_utilisateur);
                                    if (etat_mail == true && etat_age == true && etat_telephone == true) {
                                        Utilisateur utilisateur = new Utilisateur(pseudo, mail, mdp,  nom, prenom, anniversaire_reel, telephone);
                                        //Utilisateur utilisateur = new Utilisateur(pseudo, mail, nom, prenom, anniversaire_reel, telephone);
                                        //utilisateur.setMdpC(mdp);
                                        HttpSession session = request.getSession();
                                        session.setAttribute("pseudo", utilisateur.getPseudo());
                                        session.setAttribute("connecte", true);
                                        session.setAttribute("mail", mail);
                                        daoutilisateur.ajouterUtilisateur(utilisateur);
                                        forward(request, response, "jsp/page_acceuil.jsp");
                                    }
                                }
                                else{
                                    request.setAttribute("error", true);
                                }
                            }
                            else{
                                request.setAttribute("error", true);
                            }
                        }
                        else{
                            request.setAttribute("error", true);
                        }
                    }
                    else{
                        request.setAttribute("error", true);
                    }
                }
                else{
                    request.setAttribute("error", true);
                }
            }
            else{
                request.setAttribute("error", true);
            }
        }

        forward(request,response,"jsp/page_inscription.jsp");
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
