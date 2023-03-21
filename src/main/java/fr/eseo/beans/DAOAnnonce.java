package fr.eseo.beans;

import java.util.List;

public interface DAOAnnonce
{
    void ajouterAnnonce ( Annonce annonce );

    void suprimerAnnonce ( Annonce annonce );

    void modifierAnnonce ( Annonce annonce );
    //Annonce recupAnnonce(String typeA,Boolean categorieA);

    List<Annonce> recupAnnonce (String typeA);

    List<Annonce> recupAnnonceCat (Boolean categorieA);

    List<Annonce> recupAnnonceVisible(Boolean categorieA);
}