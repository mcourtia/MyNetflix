<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>MyNetflix</title>
    <link rel="stylesheet" href="<c:url value='/includes/styles/style.css'/>">
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
  </head>
  <body>
  	<div id="bloc">
  		<h1>L'ajout a bien été pris en compte !</h1>
    	<a href="<c:url value="/"/>"><button id="retacc">Retour à l'accueil</button></a>
    </div>
  </body>
</html>