<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsaw Party Information</title>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
  		 <a class="navbar-brand" href="/PartyInfor">  WarsawPartyInformation</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href=""> Area<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/PartyInfor/bulwary"> - Bulwary Wiślane</a></li>
          <li><a href="/PartyInfor/centrum"> - Centrum</a></li>
          <li><a href="/PartyInfor/praga"> - Praga Północ</a></li>
          <li><a href="/PartyInfor/pozostale"> - Pozostałe</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    	<li><a href="/PartyInfor/users/account"><span class="glyphicon glyphicon-eye-open"></span> My Account</a></li>
      <li><a href="/PartyInfor/users/add"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/PartyInfor/users/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="/PartyInfor/users/logoff"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
 
</div>

</body>
</html>
