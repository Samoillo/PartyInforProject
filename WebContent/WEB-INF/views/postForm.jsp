<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsaw Party Information</title>
</head>
<%@ include file="header.jsp" %>
<body>
<div align="right" class="container" style="max-width:15%; top:90px; right: 120px; position: fixed; color:#A0A0A0;">
	<h1><b>tell<br/>something<br/>about<br/>the<br/>party</b></h1>
</div>
	<div class="container" style="max-width: 45%; text-align: right;">
		<form:form method="post" modelAttribute="post">
			<div class="form-group">
				<form:errors path="*" />
				<br>
				<br> <label for="comment"> Desrcribe Event</label>
				<form:textarea class="form-control" rows="7" id="comment"
					placeholder="Say something about the party" path="text" />
				<br> <label for="place">Place:</label>
				<form:input class="form-control" placeholder="Where?" path="place"
					id="place" />
				<br> <label for="district">Area:</label>
				<form:select class="form-control" path="district"
					items="${districts}" itemLabel="area" itemValue="id" id="district" />
				<br> <input class="btn btn-info" type="submit" value="Inform others">
			</div>
		</form:form>
	</div>
</body>
<%@ include file="footer.jsp" %>
</html>

