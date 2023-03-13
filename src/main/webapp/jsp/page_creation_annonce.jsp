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
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<main>
    <section>
        <h2>Déposer une annonce</h2>
        <form>
            <label for="titre">Titre de l'annonce :</label>
            <input type="text" id="titre" name="titre" required>
            <label for="description">Description de l'annonce :</label>
            <textarea id="description" name="description" rows="5" required></textarea>
            <label for="prix">Prix :</label>
            <input type="number" id="prix" name="prix" required>
            <label for="ville">Ville :</label>
            <input type="text" id="ville" name="ville" required>
            <input type="submit" value="Déposer l'annonce">
        </form>
    </section>
    <section>
        <h2>Annonces récentes</h2>
        <ul>
            <li>
                <h3>Titre de l'annonce</h3>
                <p>Description de l'annonce</p>
                <p>Prix : 100€</p>
                <p>Ville : Paris</p>
            </li>
            <li>
                <h3>Titre de l'annonce</h3>
                <p>Description de l'annonce</p>
                <p>Prix : 50€</p>
                <p>Ville : Marseille</p>
            </li>
        </ul>
    </section>
</main>
</body>
</html>
