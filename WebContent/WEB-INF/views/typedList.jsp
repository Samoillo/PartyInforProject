<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Warsaw Party Information</title>
<meta content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<%@ include file="header.jsp"%>
<body>
<div align="left" class="container" style="position: inherit; width:60%; color:#A0A0A0;">
	<h1><b>selected</b></h1>

</div>

	<div style="text-align: right; max-width: 81.5%;">
		<a href="users/verification" class="btn btn-info btn-sm"> <span
			class="glyphicon glyphicon-send"></span> Send Post
		</a>
	</div>
	<br>
	<div class="container" style="width: 65%">
		<table class="table table-hover" style="word-wrap: break-word">
			<tr class="info">
				<th></th>
				<th>PLACE</th>
				<th>AREA</th>
				<th>TEXT</th>
			</tr>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td><span class="glyphicon glyphicon-minus"></span></td>
					<td>${post.place}</td>
					<td>${post.district.area}</td>
					<td>${post.text}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
<%@ include file="footer.jsp"%>
</html>


