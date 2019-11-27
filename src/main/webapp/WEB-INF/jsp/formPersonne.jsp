<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyNetflix</title>
</head>
<body>
	<div><c:out value="${message}"/></div>
	<form method="post" accept-charset="utf-8">
		<div>
			<input id="nom" name="nom" type="text" placeholder="Nom">
		</div>
		<div>
			<input id="prenom" name="prenom" type="text" placeholder="Prenom">
		</div>
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
		<button type="submit">Ajouter Personne</button>
	</form>
	<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
</body>
</html>