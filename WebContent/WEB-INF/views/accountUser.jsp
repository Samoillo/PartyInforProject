<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsaw Party Information</title>

<style>
html, 
body {
    height: 100%;
}
</style>
</head>
<%@ include file="header.jsp" %>
<body style="height:100%">


<div align="right" class="container" style="position: inherit; width:65%; color:#A0A0A0;">
	<h1><b>your account</b></h1>

</div>

<div class="container" style="width:65%">
	<table class="table table-hover">
		<tr class="success" >
			<th></th>
			<th>LOGIN</th>
			<th>FIRST NAME</th>
			<th>LAST NAME</th>
			<th>NUMBER</th>
			<th>EMAIL</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		
		<tr>
			<td><span class="glyphicon glyphicon-hand-right"></span></td>
			<td>${userLog.login}</td>
			<td>${userLog.firstName}</td>
			<td>${userLog.lastName}</td>
			<td>${userLog.number}</td>
			<td>${userLog.email}</td>

			<td align="center"><a href="edit/${userLog.id}"><span class="glyphicon glyphicon-cog"></span></a>
			<td align="center"><a href="delete/${userLog.id}"><span class="glyphicon glyphicon-trash"></span></a>
		</tr>
	</table>
</div>
<br>
<br>

<div align="right" class="container" style="position: inherit; width:65%; color:#A0A0A0;">
	<h1><b>your posts</b></h1>

</div>
<div class="container" style="width:65%">
	<table class="table table-hover" style="word-wrap: break-word">
		<tr class="success">
			<th> </th>
			<th>PLACE</th>
			<th>AREA</th>
			<th>TEXT</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>

		<c:forEach items="${posts}" var="post">

			<tr>
			<td><span class="glyphicon glyphicon-ok"></span></td>
			<td>${post.place}</td>
			<td>${post.district.area}</td>
			<td>${post.text}</td>
				
			<td align="center"><a href="../edit/${post.id}"><span class="glyphicon glyphicon-cog"></span></a></td>
			<td align="center"><a href="../delete/${post.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
			

			</tr>
		</c:forEach>
	</table>
</div>


</body>
<%@ include file="footer.jsp" %>
</html>