package fr.eseo.beans;

public interface DAOAnnonce
{
    void ajouterAnnonce ( Annonce annonce );

    void suprimerAnnonce ( Annonce annonce );

    void modifierAnnonce ( Annonce annonce );
}