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
	<h1>Ajout d'une série</h1>
	<div id="bloc">
		<div><c:out value="${message}"/></div>
		<form method="post" accept-charset="utf-8">
			<div>
				<input id="noms" name="nom" type="text" placeholder="Nom">
			</div>
			<div>
				<input id="nomOriginal" name="nomOriginal" type="text" placeholder="Nom original">
			</div>
			<div>
				<input id="anneeparution" name="anneeparution" type="text" placeholder="Année de parution">
			</div>
			<div>
				<textarea id="synopsys" name="synopsys" placeholder="Synopsis"></textarea>
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
			<div>
				<select id="idpays" name="idpays">
					<option value="0">-- Pays d'origine --</option>
					<c:forEach var="p" items="${pays}">
					<option value="${p.id}">
						<c:out value="${p.nom}"/>
					</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" id="button">Ajouter Série</button>
		</form>
		<a href="<c:url value="/"/>"><button id="retacc">Retour à l'accueil</button></a>
	</div>
</body>
</html>