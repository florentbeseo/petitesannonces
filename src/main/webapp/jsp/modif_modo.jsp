<%--
  Created by IntelliJ IDEA.
  User: Florent
  Date: 21/03/2023
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
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

      <a href="Controller?id=accueil_biens"></i> Produits</a>
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


<input type="checkbox" id="maCheckbox">
<label for="maCheckbox" >annonces à valider</label>
<confirmation id="a_valider" style="display: none;">
  <form method='POST' action="Controller?id=rendre_visible">
    <c:forEach var="annonce" items="${requestScope.a_valider}">
      <div class="annonce" >
        <c:set var="idAnnonce" value="${annonce.idAnnonce}" scope="page"/>
        <h2 class="annonce-titre">Titre : ${annonce.titre}</h2>
        <p class="annonce-prix">Prix : ${annonce.prix}</p>
        <div style="float: left"></div>
        <img class="photo" src="https://cdn.futura-sciences.com/sources/images/diaporama/1009-diapo-ponts/170314-album-pont2.jpg"height="250" width="250">
        <p class="vendeur" style="float: right">Vendeur : ${annonce.vendeur}</p>
        <p class="idAnnonce" name="idAnnonce" val${annonce.vendeur}></p>
        <p class="annonce-description">Description : ${annonce.descriptif}</p>

        <label for="lisible">rendre lisible</label>
        <input type="submit" id="lisible" name="lisible" value="4567">

        <label for="supprimer">supprimer</label>
        <input type="submit" id="supprimer" name="supprimer" value="123">

      </div>
    </c:forEach>
  </form>
</confirmation>

<toute_annonce id="toute_annoce" style="display: block;">

  <c:forEach var="annonce" items="${requestScope.a_modif}">
    <div class="annonce">
      <h2 class="annonce-titre">Titre : ${annonce.titre}</h2>
      <p class="annonce-prix">Prix : ${annonce.prix}</p>
      <div style="float: left"></div>
      <img class="photo" src="https://cdn.futura-sciences.com/sources/images/diaporama/1009-diapo-ponts/170314-album-pont2.jpg" height="250" width="250">
      <p class="vendeur" style="float: right">Vendeur : ${annonce.vendeur}</p>
      <div class="annonce-description">Description : ${annonce.descriptif}</div>
    </div>
  </c:forEach>

</toute_annonce>
<script>
  // On récupère la checkbox et les éléments de texte
  var checkbox = document.getElementById("maCheckbox");
  var a_valider = document.getElementById("a_valider");
  var toute_annonce = document.getElementById("toute_annonce");

  // On ajoute un écouteur d'événement sur le changement de la checkbox
  checkbox.addEventListener("change", function() {
    // On teste si la checkbox est cochée ou non
    if (checkbox.checked) {
      // Si oui, on affiche le premier texte et on cache le deuxième
      a_valider.style.display = "block";
      toute_annonce.style.display = "none";
    } else {
      // Si non, on fait l'inverse
      a_valider.style.display = "none";
      toute_annonce.style.display = "block";
    }
  });
</script>
</body>
</html>

