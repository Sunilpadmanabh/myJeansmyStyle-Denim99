<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AboutUs</title>
<link rel="stylesheet"
	href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resource/js/jquery.js"/>"></script>
<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/aboutus.css"/>">
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/favicon1.png"/>" />





<style>


.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

#main {
    transition: margin-left .5s;
    padding: 16px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}

body, h1, h2, h3, h4, h5 {
	font-family: "Comic Sans MS", cursive, sans-serif
}

.w3-sidenav a, .w3-sidenav h4 {
	font-weight: bold
}

.add-to-cart {
	display: inline-block;
	width: auto;
	border: 2px solid #20638f;
	padding: 0.4em 0.6em;
	color: #20638f;
	font-size: 1.2em;
	letter-spacing: 0.1em;
}

.add-to-cart:hover {
	background-color: #20638f;
	color: #ffffff;
}


</style>






</head>

<body>            




	<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="/MyJeansMyStyle/index1">Home</a>
  <a href="/MyJeansMyStyle/aboutus">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>

<div id="main">
<!--   <h2>Sidenav Push Example</h2> -->
<!--   <p>Click on the element below to open the side navigation menu, and push this content to the right.</p> -->
<!--   <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span> -->
</div>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}
</script>











<!-- importing navigation bar -->
<%@ include file="navbar.jsp"%>

<!-- Content -->
	<div class="row" style="margin-top:4px; margin-right:0px; margin-left:0px;margin-bottom:19px ">
		<div class="col-sm-4" style="margin-top:0px">
			<div class="container-fluid bg-1 text-center">
				<h3>Who Am I?</h3>
				<img src="<c:url value="/resource/images/aboutImage.png"/>" class="img-circle" alt="AboutUs" width="350"
					height="350">
				<h3>ShopIeasy a WorldWide E-Commerce Site</h3>
			</div>

		</div>

		<div class="container-fluid bg-2 text-center">
			<h3>What Am I?</h3>
			<div id="para"><p>ShopIeasy's vision is to create India's most reliable and
				frictionless commerce ecosystem that creates life-changing
				experiences for buyers and sellers.</p>
			</div>
			<div id="para"><p>We have always taken pride in our culture. There are some core
				values that have been inherent and are an integral part of our
				success story. These values are a pure reflection of what is
				important to us as a Team and Business..</p>
		</div></div>
	</div>
	
<!-- 	importing footer  -->
<%@ include file="footer.jsp"%> 

</body>
</html>