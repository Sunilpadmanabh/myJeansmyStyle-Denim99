<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="icon" type="image/x-icon"
	href="<c:url value="/resource/images/favicon1.png"/>" />
<link rel="stylesheet"
	href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>


<style>









input[type=text] {
    width: 125px;
    box-sizing: border-box;
    border: 2px solid #326EC4;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url('searchicon.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
    width: 25%;
}













.cody {
	background-color: #ffff;
	position: fixed;
  top: 0;
  width: 100%;
}







ul.navbar-nav {
	font-size: 18px;
	color: black;
	font-weight: 900;
	/* 	text-indent: 0em; */
	font-family: Courier New;
	text-align: middle;
	
	
	
	/* 	padding-left: 1.8em; */
}


.navbar-brand {
	font-family: Comic Sans MS;
	font-size: 5px;
	color: black;
	text-transform: uppercase;
	border: 2px solid white;
	border-radius: .3em;
	text-align: center;
	margin: 0;
}

.dropbtn {

font-size: 12px;
	color: #326EC4;
	font-weight: 1400;
	/* 	text-indent: 0em; */
	font-family: Courier New;
	text-align: middle;



	background-color: white;
/*     color: blue; */
	padding: 16px;
	font-size: 20px;
	border: none;
	cursor: pointer;

}

.dropdown {
	position: relative;
	display: inline-block;
	font-family: Courier New;
	background-color: black;
	color: #326EC4;
	
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: white;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	color: #326EC4;
}

.dropdown-content a {
	color: #326EC4;
	
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	font-family: Courier New;
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #f1f1f1;
	color: #326EC4;
}
</style>


<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/overall.css"/>">




</head>
<body>

	<div class="collapse navbar-collapse" id="myNavbar">
		
		<ul class="nav navbar-nav">
			<li>  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;  </span> 
			<%-- 				<a href=" <c:url value="/index1" />">Home</a></li> --%>
				<%-- 				<li><a href=" <c:url value="/getAllProducts" />">Product List</a></li> --%>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			
			
			
			
				<div class="dropdown">         
					<button class="dropbtn"><span
						class="	fa fa-group"></span>Category</button>
					<div class="dropdown-content">
						 <a href=" <c:url value="/getAllProductsForMen" />">Men</a> 
						 <a href=" <c:url value="/getAllProductsForWomen" />">Women</a>
						 <a href=" <c:url value="/getAllProductsForKids" />">Kids</a>
					</div>
				</div></li>

			<!-- 			Only admin can view this link -->
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href=" <c:url value="/admin/product/addProduct" />">AddProduct</a></li>
				<li><a href=" <c:url value="/admin/deleteUser" />">Delete User</a></li>
			</security:authorize>
		</ul>

		<!-- 	<ul class="nav navbar-nav navbar-right"> -->
		<ul class="nav navbar-nav">
			<c:if test="${!empty pageContext.request.userPrincipal.name}">

				<security:authorize access="!hasRole('ROLE_ADMIN')">
					<li><a href="<c:url value="/cart/getCartById" />"><span
							class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
				</security:authorize>
				<li><a href="<c:url value="/index1" />"><span
						class="glyphicon glyphicon-shopping-user"></span> <b>Welcome:${currentUser}</b></a></li>
				<li><a href="<c:url value="/j_spring_security_logout" />"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</c:if>
		</ul>


		<!-- 			<ul class="nav navbar-nav navbar-right"> -->
		<ul class="nav navbar-nav">
		
		
		
		
			<c:if test="${pageContext.request.userPrincipal.name==null}">
				<security:authorize access="!hasRole('ROLE_ADMIN')">
					<li><a href="<c:url value="/cart/getCartById" />"><span
							class="glyphicon glyphicon-shopping-cart"></span>MyCart</a></li>
				</security:authorize>
				
				<li><a href="<c:url value="/customer/registration" />"><span
						class="glyphicon glyphicon-user"></span> SignUp</a></li>
						
				<li><a href="<c:url value="/login" />"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
		</ul>
		
<form>
&nbsp;&nbsp;  <input type="text" name="search" placeholder="Search..">
</form>
		
		
	</div>
	
	
	
	
	</div>
	






</body>
</html>