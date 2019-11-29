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
	<form action="/myNetflixJsp/addEpisode" method="post" accept-charset="utf-8">
		<div>Série : <c:out value="${serie.nom}"/></div>
		<input id="idserie" name="idserie" type="hidden" value="<c:out value="${serie.id}"/>">
		<div>
			<select id="idsaison" name="idsaison">
				<option value="0">-- Saison --</option>
				<c:forEach var="s" items="${saison}">
				<option value="${s.id}">
					<c:out value="${s.numero}"/>
				</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<input id="numero" name="numero" type="text" placeholder="Numéro épisode">
		</div>
		<div>
			<input id="titre" name="titre" type="text" placeholder="Titre">
		</div>
		<div>
			<input id="titreoriginal" name="titreoriginal" type="text" placeholder="Titre original">
		</div>
		<div>
			<input id="duree" name="duree" type="text" placeholder="Durée">
		</div>
		<div>
			<textarea id="resume" name="resume" placeholder="Résumé"></textarea>
		</div>
		<div>
			<input id="dateReal" name="dateReal" type="text" placeholder="Date de réalisation AAAA-MM-DD">
		</div>
		<div>
			<input id="dateDiff" name="dateDiff" type="text" placeholder="Date de diffusion AAAA-MM-DD">
		</div>
		<div>
			<select id="idpublic" name="idpublic">
				<option value="0">-- Public --</option>
				<c:forEach var="p" items="${publicAge}">
				<option value="${p.id}">
					<c:out value="${p.libelle}"/>
				</option>
				</c:forEach>
			</select>
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
		<button type="submit">Ajouter Épisode</button>
	</form>
	<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
</body>
</html>