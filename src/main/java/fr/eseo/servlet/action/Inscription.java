package fr.eseo.servlet.action;

import fr.eseo.beans.DAOUtilisateur;
import fr.eseo.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Inscription implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, DAOUtilisateur daoutilisateur) throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pseudo = request.getParameter("pseudo");
        String mail = request.getParameter("mail");
        String date_naissance = request.getParameter("date");
        String telephone = request.getParameter("telephone");
        String mdp = request.getParameter("mdp");

        List<Utilisateur> liste_utilisateur = daoutilisateur.listerUtilisateurs();
        System.out.println("telephone: "+telephone);

        //boolean champ_rempli = false;
        boolean ok = false;
        if(nom != null && !nom.equals("")){
            if(prenom != null && !prenom.equals("")) {
                if(pseudo != null && !pseudo.equals("")){
                    if(mail != null && !mail.equals("")){
                        if(date_naissance != null && !date_naissance.equals("")){
                            if(telephone != null && !telephone.equals("")){
                                if(mdp != null && !mdp.equals("")){
                                    boolean etat_age = verification_age(date_naissance, request);
                                    boolean etat_telephone = verificattion_telephone(telephone, request);
                                    //boolean etat_mail = verification_mail(mail, request, liste_utilisateur);
                                    if(/*etat_mail == true &&*/ etat_age == true && etat_telephone == true) {
                                        HttpSession session = request.getSession();
                                        session.setAttribute("pseudo", pseudo);
                                        forward(request, response, "jsp/page_profil.jsp");
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
        /*else {
            request.setAttribute("error", true);                    //piste pour apres avoir regler le proleme du double lancement
        }*/

        /*boolean existe = false;
        if(champ_rempli == true) {
            for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i).getPseudo() == Pseudo_utilisateur) {
                    if (liste.get(i).getMdp() == motPasse) {
                        existe = true;
                    }
                }                                                               //piste pour apres avoir regler le proleme du double lancement
            }
            if (existe == true) {
                HttpSession session = request.getSession();
                session.setAttribute("user", Pseudo_utilisateur);
                forward(request, response, "jsp/page_profil.jsp");
            }
        }
        else{
            request.setAttribute("Mdp_error", true);
        }*/

        forward(request,response,"jsp/page_inscription.jsp"); // a modifier lorsque la page d'acceuil sera faite
    }

    private boolean verification_age(String date_naissance, HttpServletRequest request){

        boolean etat_age=false;

        String[] parts = date_naissance.split("-");
        int annee = Integer.parseInt(parts[0]);
        if (annee <= 2005) {
            etat_age = true;
        }
        else{
            request.setAttribute("Age_error", true);
        }

        return etat_age;
    }

    private boolean verification_mail(String mail, HttpServletRequest request, List<Utilisateur>liste_utilisateur){

        boolean etat_mail = false;

        for (int i = 0; i < liste_utilisateur.size(); i++) {
            if (liste_utilisateur.get(i).getAdresse() != mail) {
                etat_mail = true;
            }
        }
        if(etat_mail == true){
            request.setAttribute("Mail_error", true);
        }

        return etat_mail;
    }

    private boolean verificattion_telephone (String telephone, HttpServletRequest request){

        boolean etat_telephone = false;

        if (telephone.length() == 10){
            etat_telephone = true;
        }
        else {
            request.setAttribute("Telephone_error", true);
        }

        return etat_telephone;
    }
}
