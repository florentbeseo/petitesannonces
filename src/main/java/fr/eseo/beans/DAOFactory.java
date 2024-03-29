package fr.eseo.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Cette classe permet d'établir un lien entre le site et la base de donnée
    @author Amiaud Antoine
    @version 2.1
    @since 1.3
    @see DAOAnnonceMariaDB
    @see DAOUtilisateurMariaDB
 */
public class DAOFactory
{
    /*
        Permet l'instanciation d'un DAOFactory unique
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private static volatile DAOFactory instance = null;
    /*
        url de connection à la base de donnée
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private String url;
    /*
        Nom d'utilisateur de base de donnée
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private String username;
    /*
        mot de passe de la base de donnée
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
     */
    private String password;
    //Constructeur
    /*
        Constructeur vide
        @author Amiaud Antoine
        @version 1.0
        @since 0.0
        @param aucun
        @return aucun
     */
    private DAOFactory () {}
    public static DAOFactory getInstance()
    {
        if(DAOFactory.instance == null)
        {
            synchronized(DAOFactory.class)
            {
                if(DAOFactory.instance == null)
                {
                    instance = new DAOFactory();
                }
            }
        }
        return DAOFactory.instance;
    }
    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, username, password);
    }
    private void setParamMariaDB(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public DAOUtilisateur getUtilisateurDao(String type)
    {
        switch(type)
        {
            case "MariaDB":
                setParamMariaDB("jdbc:mariadb://localhost:3306/petiteannonce", "root", "MqcvTV29");
                return new DAOUtilisateurMariaDB(this);
            default:
                return null;
        }
    }
    public DAOAnnonce getAnnonceDao(String type)
    {
        switch(type)
        {
            case "MariaDB":
                setParamMariaDB("jdbc:mariadb://localhost:3306/petiteannonce", "root", "MqcvTV29");
                return new DAOAnnonceMariaDB (this);
            default:
                return null;
        }
    }
}
