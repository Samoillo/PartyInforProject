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
<body style="height:100%; background:url(''); 
background-repeat:no-repeat; background-attachment: fixed; background-position: center; ">

<div class="container" style="width:65%">
	<table class="table table-hover">
	<tr class="danger">
	<th></th>
	<th>FIRST NAME</th>
	<th>LAST NAME</th>
	<th>NUMBER</th>
	<th>EMAIL</th>
	<th>EDIT</th>
	<th>DELETE</th>
	</tr>
	
		<c:forEach items="${users}" var="user">
			
	<tr>
	<td><span class="glyphicon glyphicon-user"></span></td>
	<td>${user.firstName}</td>
	<td>${user.lastName}</td>
	<td>${user.number}</td>
	<td>${user.email}</td>
	
	<td align="center"><a href="edit/${user.id}"><span class="glyphicon glyphicon-cog"></span></a>
	<td align="center"><a href="delete/${user.id}"><span class="glyphicon glyphicon-trash"></span></a>
	</tr>
		</c:forEach>
		
	</table>
	</div>
</body>
<%@ include file="footer.jsp" %>
</html>

