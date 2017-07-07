<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsaw Party Information</title>
<script>

</script>
</head>
<%@ include file="header.jsp" %>
<body>
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
	<form:input class="form-control" placeholder="New Password" type="password" path="password" />
		</div>
		<br>
		<div class="input-group">
		<span class="input-group-addon"><i
					class="glyphicon glyphicon-pushpin"></i></span>
	<form:input class="form-control" placeholder="First Name" path="firstName" />
		</div>
		<br>
		<div class="input-group">
		<span class="input-group-addon"><i
					class="glyphicon glyphicon-pushpin"></i></span>
	<form:input class="form-control" placeholder="Last Name" path="lastName" />
		</div>
		<br>
		<div class="input-group">
		<span class="input-group-addon"><i
					class="glyphicon glyphicon-phone-alt"></i></span>
	<form:input class="form-control" placeholder="Phone Number" type="tel" path="number" />
		</div>
		<br>
		<div class="input-group">
		<span class="input-group-addon"><i
					class="glyphicon glyphicon-envelope"></i></span>
	<form:input class="form-control" placeholder="E-Mail" type ="email" path="email" />
		</div>
		<br>
		<input class="btn btn-info" type="submit" value="Change account">
	</form:form>
	</div>
</body>
<%@ include file="footer.jsp" %>
</html>

