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
	<h1>Ajout d'une saison</h1>
	<div id="bloc">
		<div><c:out value="${message}"/></div>
		<form method="post" accept-charset="utf-8">
			<div>
				<select id="idserie" name="idserie">
					<option value="0">-- Série --</option>
					<c:forEach var="s" items="${serie}">
					<option value="${s.id}">
						<c:out value="${s.nom}"/>
					</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input id="numero" name="numero" type="text" placeholder="Numéro saison">
			</div>
			<div>
				<textarea id="resume" name="resume" placeholder="Résumé"></textarea>
			</div>
			<div>
				<input id="annee_diffusion" name="annee_diffusion" type="text" placeholder="Année de diffusion">
			</div>
			<div>
				<select id="idstatut" name="idstatut">
					<option value="0">-- Statut --</option>
					<c:forEach var="st" items="${statut}">
					<option value="${st.id}">
						<c:out value="${st.libelle}"/>
					</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" id="button">Ajouter Saison</button>
		</form>
		<a href="<c:url value="/"/>"><button id="retacc">Retour à l'accueil</button></a>
	</div>
</body>
</html>