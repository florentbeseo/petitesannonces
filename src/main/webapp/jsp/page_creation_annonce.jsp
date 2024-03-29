<%--
  Created by IntelliJ IDEA.
  User: tgeor
  Date: 13/03/2023
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Creation Annonce</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
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

    <main>
        <section>
            <h2>Déposer une annonce</h2>

            <form method='POST' action='Controller?id=nouvelle_annonce'>
                <label for="titre">Titre de l'annonce :</label>
                <input type="text" id="titre" name="titre" required>

                <label for="description">Description de l'annonce :</label>
                <textarea id="description" name="description" rows="5" required></textarea>

                <label for="prix">Prix :</label>
                <input type="number" id="prix" name="prix" required>

                <label>TYPE</label>
                    <p>
                        <input type="radio" name="type" id="véhicule" value="véhicule" checked required>
                        <label for="véhicule">véhicule</label>
                    </p>
                    <p>
                        <input type="radio" name="type" id="mobilier" value="mobilier" required>
                        <label for="mobilier">mobilier</label>
                    </p>
                    <p>
                        <input type="radio" name="type" id="exterieur" value="exterieur" required>
                        <label for="exterieur">exterieur</label>
                    </p>
                    <p>
                        <input type="radio" name="type" id="sport" value="sport" required>
                        <label for="sport">sport</label>
                    </p>
                    <p>
                        <input type="radio" name="type" id="animalier" value="animalier" required>
                        <label for="animalier">animalier</label>
                    </p>
                    <p>
                        <input type="radio" name="type" id="numerique" value="numerique" required>
                        <label for="numerique">numerique</label>
                    </p>
                    <p>
                        <input type="radio" name="type" id="Loisir" value="Loisir" required>
                        <label for="Loisir">Loisir</label>
                    </p>
                    <p>
                        <input type="radio" name="type" id="travail" value="travail" required>
                        <label for="travail">travail</label>
                    </p>
                <label>EXTRA</label>
                <p>
                    <input type="radio" name="extra" id="objet" value="objet" checked required>
                    <label for="objet">objet(s)</label></p>
                <p>
                    <input type="radio" name="extra" id="temps" value="€/heure" required>
                    <label for="temps">€/heure</label>
                </p>

                <label>état</label>
                <p>
                    <input type="radio" name="etat" id="neuf" value="neuf" required>
                    <label for="neuf">neuf</label>
                </p>
                <p>
                    <input type="radio" name="etat" id="intacte" value="intacte" required>
                    <label for="intacte">intacte</label>
                </p>
                <p>
                    <input type="radio" name="etat" id="use" value="use" checked required>
                    <label for="use">usé</label>
                </p>
                <p>
                    <input type="radio" name="etat" id="abime" value="abime" required>
                    <label for="abime">abimé</label>
                </p>
                <p>
                    <input type="radio" name="etat" id="casse" value="casse" required>
                    <label for="casse">cassé</label>
                </p>
                <p>
                    <input type="radio" name="etat" id="poudre" value="en poudre" required>
                    <label for="poudre">en poudre</label>
                </p>

                <label for="categorie">categorie</label>
                <p id="categorie">
                    <input type="radio" name="categorie" id="bien" value=true checked required>
                    <label for="bien">bien</label>

                    <input type="radio" name="categorie" id="service" value=false required>
                    <label for="service">service</label>
                </p>
                <input type="submit" name="log" value="Déposer l'annonce">
            </form>
        </section>

        <section>
            <h2>Annonces récentes</h2>
            <ul>
                <li>
                    <c:forEach var="annonce" items="${requestScope.liste_annonce}">
                        <h3>${annonce.titre}</h3>
                        <p>Descriptif: ${annonce.descriptif}</p>
                        <p>Prix : ${annonce.prix}</p>
                    </c:forEach>
                </li>
            </ul>
        </section>
    </main>
</body>
</html>
