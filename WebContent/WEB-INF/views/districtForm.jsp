<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsaw Party Information</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<br>
	<br>
	<div class="container" style="max-width: 45%; text-align: right;">
		<form:form method="post" modelAttribute="district">
			<form:errors path="*" />
			<br>
			<br>

			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-apple"></i></span>
				<form:input class="form-control" placeholder="Area" path="area" />
				</div>
				<br>
			<input class="btn btn-info" type="submit" value="Add Area">
		</form:form>
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>

