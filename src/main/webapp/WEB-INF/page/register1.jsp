<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">


<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Transparent Register Form</title>

		<style>
body
{
	margin: 0;
	padding: 0;
	background-size: cover;
	font-family: sans-serif;
}

.anil{
color:yellow;
}


.loginBox
{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	width: 400px;
	height: 540px;
	padding: 80px 40px;
	box-sizing: border-box;
	background: rgba(0,0,0,.5);
}
.user
{
	width: 100px;
	height: 100px;
	border-radius: 50%;
	overflow: hidden;
	position: absolute;
	top: calc(-100px/2);
	left: calc(50% - 50px);
}
h2
{
	margin: 0;
	padding: 0 0 20px;
	color: #efed40;
	text-align: center;
}
.loginBox p
{
	margin: 0;
	padding: 0;
	font-weight: bold;
	color: #fff;
}
.loginBox input
{
	width: 100%;
	margin-bottom: 20px;
}
.loginBox input[type="text"],
.loginBox input[type="password"]
{
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
}
::placeholder
{
	color: rgba(255,255,255,.5);
}
.loginBox input[type="submit"]
{
	border: none;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
	background: #ff267e;
	cursor: pointer;
	border-radius: 20px;
}
.loginBox input[type="submit"]:hover
{
	background: #efed40;
	color: #262626;
}
.loginBox a
{
	color: #fff;
	font-size: 14px;
	font-weight: bold;
	text-decoration: none;
	
}

		</style>
		
 	</head> 

	<body background="<c:url value="/resource/images/bg291.jpg"/>">
 <%@ include file="navbar1.jsp"%> 
	
	
	
	
	
		<div class="loginBox">
		<img src="<c:url value="/resource/images/user.png"/>" class="user">
			<h2 class="anil">Signup to Denim99</h2>
			
			
			
			<form:form action="registration" method="post" commandName="customer">
			<form name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post">
			
				<p>Email</p>
				<form:input name="users.emailId" path="users.emailId" type="text" placeholder="Enter Email" required="true"/>
				
			
				<p>Name</p>
				<form:input name="firstName" path="firstName" type="text" placeholder="Enter Name" required="true"/>
				
				
				<p>Password</p>
				<form:input name="users.password" path="users.password" type="password" placeholder="Enter Password" required="true"/>
				
				
				<input type="submit" class="button"  value="Register">
			      </form:form>
		
				<p>By clicking Register, you agree on our <a href="#">terms and condition</a>.</p>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="index1/">GoBack</a>
			</form>
		</div>
	</body>
	
</html>
