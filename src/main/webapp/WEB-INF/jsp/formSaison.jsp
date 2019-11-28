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
		<button type="submit">Ajouter Saison</button>
	</form>
	<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
</body>
</html>