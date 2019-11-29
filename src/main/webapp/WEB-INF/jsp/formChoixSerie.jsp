<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyNetflix</title>
</head>
<body>
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
		<button type="submit">Sélectionner série</button>
	</form>
</body>
</html>