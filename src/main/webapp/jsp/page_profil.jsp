<%--
  Created by IntelliJ IDEA.
  User: Florent
  Date: 07/03/2023
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Page Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="HTML/style/styles.css">
</head>

<body>
    <header>
        <div class="inner-width">
            <a href="Controller?id=accueil">
                <h1 class="logo img">Annonces<span style="color:red;">et</span>Vous</h1>
                <i class="menu-toggle-btn fas fa-bars"></i>
            </a>
            <nav class="navigation-menu">

                <c:if test="${connecte}">
                    <a href="Controller?id=mes_annonces" class="aj_btn">Mes Annonces</a>
                </c:if>

                <a href="Controller?id=accueil_biens"></i> Biens</a>
                <a href="Controller?id=accueil_services"></i> Services</a>
                <a href="Controller?id=aide"></i> Aide</a>

                <c:if test="${connecte}">
                    <a href="Controller?id=profile" class="aj_btn">${sessionScope.pseudo}</a>
                </c:if>
                <c:if test="${!connecte}">
                    <a href="Controller?id=connection" class="aj_btn">Se Connecter</a>
                </c:if>

            </nav>
        </div>
    </header>

    <h2>Session de ${sessionScope.pseudo}</h2><br>

    <form class="login">
        <label><b>Nom de famille :</b></label>
        <p>${sessionScope.nom}</p>
        <br><br>
        <label><b>Prenom :</b></label>
        <p>${sessionScope.prenom}</p>
        <br><br>
        <label><b>Pseudo :</b></label>
        <p>${sessionScope.pseudo}</p>
        <br><br>
        <label><b>Mail personnel :</b></label>
        <p>${sessionScope.mail}</p>
        <br><br>
        <label><b>Date de naissance :</b></label>
        <p>${sessionScope.date}</p>
        <br><br>
        <label><b>Telephone :</b></label>
        <p>${sessionScope.tel}</p>
        <br><br>
        <label><b>Mot de passe :</b></label>
        <p>${sessionScope.mdp}</p>
        <br><br>
        <a href="Controller?id=modification">Modification</a>
        <br><br>
        <a href="Controller?id=deconnexion">Déconnexion</a>
    </form><br>

    <c:if test="${admin}">
        <form class="login" method="POST" action="Controller?id=modification_admin">
            <input type="email" name="recherche" id="recherche" placeholder="Recherche utilisateur...">
            <input type="submit" name="chercher" value="Chercher">
            <br>
            <a href="Controller?id=rendre_visible"></i> modération des annonces</a>
            <c:if test="${admin_utilisateur}">
                <br>
                <c:if test="${isBloque}">
                    <a href="Controller?id=debloquer_compte">Debloquer Compte de ${mail_selec}</a>
                </c:if>
                <c:if test="${!isBloque}">
                    <a href="Controller?id=bloquer_compte">Bloquer Compte de ${mail_selec}</a>
                </c:if>
                <br><br>
                <a href="Controller?id=supprimer">Supprimer Compte de ${mail_selec}</a>
                <br><br>
                <a href="Controller?id=modifier_indice_satisfaction">Modifier l'Indice de ${mail_selec}</a>
                <br><br>
                <c:if test="${bloque_admin}">
                    <a href="Controller?id=bloquer_admin">Bloquer Droit Admin de ${mail_selec}</a>
                </c:if>
            </c:if>
            <br>
            <a href="Controller?id=creer_compte">Créer Compte</a>
            <br><br>
            <a href="Controller?id=admin_vers_valid_annonce">Faire Modération Annonce</a>
            <br>
        </form>
    </c:if>

    <c:if test="${creation}">
        <form class="login" method="POST" action="Controller?id=creer_compte">
            <label><b>Nom de famille :</b></label>
            <input type="text" name="nom" id="Uname" placeholder="Nom">
            <br><br>
            <label><b>Prenom :</b></label>
            <input type="text" name="prenom" id="name" placeholder="Prenom">
            <br><br>
            <label><b>Pseudo :</b></label>
            <input type="text" name="pseudo" id="pseudo" placeholder="Pseudo ">
            <br><br>
            <label><b>Mail personnel :</b></label>
            <input type="email" name="mail" id="mail" placeholder="Mail ">
            <br><br>
            <label><b>Date de naissance :</b></label>
            <input type="date" name="date" id="date" placeholder="Date ">
            <br><br>
            <label><b>Telephone :</b></label>
            <input type="text" name="telephone" id="tel" placeholder="Tel  ">
            <br><br>
            <label><b>Mot de passe :</b></label>
            <input type="password" name="mdp" id="Pass" placeholder="Mot de passe   ">
            <br><br>
            <input type="submit" name="log" id="log" value="Creer un compte">
        </form>
    </c:if>
    <br>
    <c:if test="${modif_ind}">
        <form class="login" method="POST" action="Controller?id=modifier_indice_satisfaction">
            <label><b>Indice de Satisfaction:</b></label>
            <input type="number" name="indice" placeholder=${ind} >
            <input type="submit" name="valider" value="Valider">
        </form>
    </c:if>
</body>
</html>
