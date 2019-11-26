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
			<textarea id="resume" name="resume" placeholder="Résumé"></textarea>
		</div>
		<div>
			<input id="annee" name="annee" type="number" placeholder="Année de diffusion">
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
		<button type="submit">Ajouter Saison</button>
	</form>
	<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
</body>
</html>