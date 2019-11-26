<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyNetflix</title>
</head>
<body>
	<a href="<c:url value="/addPersonne"/>">Ajouter une personne</a>
	<a href="<c:url value="/addSerie"/>">Ajouter une série</a> 
	<a href="<c:url value="/addSaison"/>">Ajouter une saison</a>  
	<a href="<c:url value="/addEpisode"/>">Ajouter un épisode</a>   
</body>
</html>