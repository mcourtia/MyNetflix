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
			<select id="serie" name="serie">
				<option value="0">-- Série --</option>
				<c:forEach var="s" items="${serie}">
				<option value="${s.key}">
					<c:out value="${s.value}"/>
				</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<input id="numsaison" name="numsaison" type="number" placeholder="Numéro saison">
		</div>
		<div>
			<input id="numepisode" name="numepisode" type="number" placeholder="Numéro épisode">
		</div>
		<div>
			<input id="titre" name="titre" type="text" placeholder="Titre">
		</div>
		<div>
			<input id="titreOriginal" name="titreOriginal" type="text" placeholder="Titre original">
		</div>
		<div>
			<input id="duree" name="duree" type="number" placeholder="Durée">
		</div>
		<div>
			<textarea id="resume" name="resume" placeholder="Résumé"></textarea>
		</div>
		<div>
			<input id="dateReal" name="dateReal" type="text" placeholder="Date de réalisation">
		</div>
		<div>
			<input id="dateDiff" name="dateDiff" type="text" placeholder="Date de diffusion">
		</div>
		<div>
			<select id="public" name="public">
				<option value="0">-- Public --</option>
				<c:forEach var="p" items="${public}">
				<option value="${p.key}">
					<c:out value="${p.value}"/>
				</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<select id="statut" name="statut">
				<option value="0">-- Statut --</option>
				<c:forEach var="st" items="${statut}">
				<option value="${st.key}">
					<c:out value="${st.value}"/>
				</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit">Ajouter Épisode</button>
	</form>
	<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
</body>
</html>