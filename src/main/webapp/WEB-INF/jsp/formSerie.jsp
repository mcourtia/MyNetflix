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
			<input id="nomOriginal" name="nomOriginal" type="text" placeholder="Nom original">
		</div>
		<div>
			<input id="annee" name="annee" type="number" placeholder="Année de parution">
		</div>
		<div>
			<textarea id="synopsys" name="synopsys" placeholder="Synopsys"></textarea>
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
		<div>
			<select id="pays" name="pays">
				<option value="0">-- Pays d'origine --</option>
				<c:forEach var="p" items="${pays}">
				<option value="${p.key}">
					<c:out value="${p.value}"/>
				</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit">Ajouter Série</button>
	</form>
	<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
</body>
</html>