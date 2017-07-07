<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsaw Party Information</title>
</head>
<%@ include file="header.jsp" %>
<body>
	<table>
		<tr>
			<th>AREA</th>
		</tr>

		<c:forEach items="${districts}" var="district">

			<tr>
				<td>${district.area}</td>

				<td><a href="edit/${district.id}">EDYCJA</a></td>
				<td><a href="delete/${district.id}">USUWANIE</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="/PartyInfor">Wróć do listy</a>
</body>
<%@ include file="footer.jsp" %>
</html>

