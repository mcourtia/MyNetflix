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
	<h1>Choix de la série</h1>
	<div id="bloc">
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
			<button type="submit" id="button">Sélectionner série</button>
		</form>
		<a href="<c:url value="/"/>"><button id="retacc">Retour à l'accueil</button></a>
	</div>
</body>
</html>