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
	<h1>Console d'administration</h1>
	<div id="menu">
		<div id="personne">
			<a href="<c:url value="/addPersonne"/>">
				<img src='<c:url value="/includes/img/personne.png"></c:url>' alt="Ajouter une personne" />
			</a>
		</div>
		<div id="serie">
			<a href="<c:url value="/addSerie"/>">
				<img src='<c:url value="/includes/img/serie.png"></c:url>' alt="Ajouter une série"/>
			</a> 
		</div>
		<div id="saison">
			<a href="<c:url value="/addSaison"/>">
				<img src='<c:url value="/includes/img/saison.png"></c:url>' alt="Ajouter une saison"/>
			</a>  
		</div>
		<div id="episode">
			<a href="<c:url value="/choixSerie"/>">
				<img src='<c:url value="/includes/img/episode.png"></c:url>' alt="Ajouter un épisode" />
			</a>   
		</div>
	</div>
</body>
</html>