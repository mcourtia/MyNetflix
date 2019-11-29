<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyNetflix</title>
<link rel="stylesheet" href="<c:url value='/includes/styles/style.css'/>">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
	<h1>Ajout d'une personne</h1>
	<div id="bloc">
		<div><c:out value="${message}"/></div>
		<form method="post" accept-charset="utf-8">
			<div>
				<select id="civilite" name="civilite">
					<option value="0">-- Civilite --</option>
					<c:forEach var="civ" items="${civilite}">
					<option value="${civ.id}">
						<c:out value="${civ.libelle}"/>
					</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input id="nom" name="nom" type="text" placeholder="Nom">
			</div>
			<div>
				<input id="prenom" name="prenom" type="text" placeholder="Prenom">
			</div>
			<button type="submit" id="button">Ajouter Personne</button>
		</form>
		<a href="<c:url value="/"/>"><button id="retacc">Retour à l'accueil</button></a>
	</div>
</body>
</html>