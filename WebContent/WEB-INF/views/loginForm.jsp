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
<div align=right class="container" style="max-width: 45%; position: relative; color:#A0A0A0;">
	<h1><b>sign in</b></h1>
</div>
	<div class="container" style="max-width: 45%; text-align: right;">
		<form:form method="post" modelAttribute="user">
			<form:errors path="*" />
			<br>
			<br>
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span>
				<form:input class="form-control" placeholder="Login" path="login" />
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-lock"></i></span>
				<form:input class="form-control" placeholder="Password"
					type="password" path="password" />
			</div>
			<br>
			<input class="btn btn-success" type="submit" value="Login">
		</form:form>
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>

