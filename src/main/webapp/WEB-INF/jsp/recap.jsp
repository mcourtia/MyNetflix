<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>MyNetflix</title>
  </head>
  <body>
    Nom : <c:out value="${personne.nom}"/>
    Prenom : <c:out value="${personne.prenom}"/>
  </body>
</html>