<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>









    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Collapsible sidebar using Bootstrap 4</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="style5.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>












<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<style>



















/*
    DEMO STYLE
*/
@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";


body {
    font-family: 'Poppins', sans-serif;
    background: #fafafa;
}

p {
    font-family: 'Poppins', sans-serif;
    font-size: 1.1em;
    font-weight: 300;
    line-height: 1.7em;
    color: #999;
}

a, a:hover, a:focus {
    color: inherit;
    text-decoration: none;
    transition: all 0.3s;
}

.navbar {
    padding: 15px 10px;
    background: #fff;
    border: none;
    border-radius: 0;
    margin-bottom: 40px;
    box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
}

.navbar-btn {
    box-shadow: none;
    outline: none !important;
    border: none;
}

.line {
    width: 100%;
    height: 1px;
    border-bottom: 1px dashed #ddd;
    margin: 40px 0;
}

/* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */

.wrapper {
    display: flex;
    width: 100%;
    align-items: stretch;
    perspective: 1500px;
}


#sidebar {
    min-width: 250px;
    max-width: 250px;
    background: #7386D5;
    color: #fff;
    transition: all 0.6s cubic-bezier(0.945, 0.020, 0.270, 0.665);
    transform-origin: bottom left;
}

#sidebar.active {
    margin-left: -250px;
    transform: rotateY(100deg);
}

#sidebar .sidebar-header {
    padding: 20px;
    background: #6d7fcc;
}

#sidebar ul.components {
    padding: 20px 0;
    border-bottom: 1px solid #47748b;
}

#sidebar ul p {
    color: #fff;
    padding: 10px;
}

#sidebar ul li a {
    padding: 10px;
    font-size: 1.1em;
    display: block;
}
#sidebar ul li a:hover {
    color: #7386D5;
    background: #fff;
}

#sidebar ul li.active > a, a[aria-expanded="true"] {
    color: #fff;
    background: #6d7fcc;
}


a[data-toggle="collapse"] {
    position: relative;
}

.dropdown-toggle::after {
    display: block;
    position: absolute;
    top: 50%;
    right: 20px;
    transform: translateY(-50%);
}

ul ul a {
    font-size: 0.9em !important;
    padding-left: 30px !important;
    background: #6d7fcc;
}

ul.CTAs {
    padding: 20px;
}

ul.CTAs a {
    text-align: center;
    font-size: 0.9em !important;
    display: block;
    border-radius: 5px;
    margin-bottom: 5px;
}

a.download {
    background: #fff;
    color: #7386D5;
}

a.article, a.article:hover {
    background: #6d7fcc !important;
    color: #fff !important;
}



/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
#content {
    width: 100%;
    padding: 20px;
    min-height: 100vh;
    transition: all 0.3s;
}

#sidebarCollapse {
    width: 0px;
    height: 0px;
    background: #f5f5f5;
/*     cursor: pointer; */
}

#sidebarCollapse span {
    width: 0%;
    height: 0px;
    margin: 0 auto;
/*     display: block; */
/*     background: #555; */
    transition: all 0.8s cubic-bezier(0.810, -0.330, 0.345, 1.375);
    transition-delay: 0.2s;
}

#sidebarCollapse span:first-of-type {
    transform: rotate(45deg) translate(2px, 2px);
}
#sidebarCollapse span:nth-of-type(2) {
    opacity: 0;
}
#sidebarCollapse span:last-of-type {
    transform: rotate(-45deg) translate(1px, -1px);
}


#sidebarCollapse.active span {
    transform: none;
    opacity: 1;
    margin: 5px auto;
}


/* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */
@media (max-width: 768px) {
    #sidebar {
        margin-left: -250px;
        transform: rotateY(90deg);
    }
    #sidebar.active {
        margin-left: 0;
        transform: none;
    }
    #sidebarCollapse span:first-of-type,
    #sidebarCollapse span:nth-of-type(2),
    #sidebarCollapse span:last-of-type {
        transform: none;
        opacity: 1;
        margin: 5px auto;
    }
    #sidebarCollapse.active span {
        margin: 0 auto;
    }
    #sidebarCollapse.active span:first-of-type {
        transform: rotate(45deg) translate(2px, 2px);
    }
    #sidebarCollapse.active span:nth-of-type(2) {
        opacity: 0;
    }
    #sidebarCollapse.active span:last-of-type {
        transform: rotate(-45deg) translate(1px, -1px);
    }

}


#myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
  background-color: white;
  color: #4d6de6;
  cursor: pointer;
  padding: 15px;
  border-radius: 4px;
}

#myBtn:hover {
  background-color: #555;
}







* {
    box-sizing: border-box;
}

body {
    margin: 0;
    font-family: Arial;
}

/* The grid: Four equal columns that floats next to each other */
.column {
    float: left;
    width: 25%;
    padding: 15px;
}

/* Style the images inside the grid */
.column img {
    opacity: 0.95; 
    cursor: pointer; 
}

.column img:hover {
    opacity: 1;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* The expanding image container */
.container {
/*     position: relative; */
/*     display: none; */
}

/* Expanding image text */
#imgtext {
    position: absolute;
    bottom: 15px;
    left: 15px;
    color: white;
    font-size: 20px;
}

/* Closable button inside the expanded image */
.closebtn {
    position: absolute;
    top: 10px;
    right: 15px;
    color: white;
    font-size: 35px;
    cursor: pointer;
}


img:hover {
    opacity: 0.5;
    filter: alpha(opacity=50); /* For IE8 and earlier */
}


body {
    font-family: "Lato", sans-serif;
    transition: background-color .5s;
}

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
    
    
     opacity: 0.5; 
     filter: alpha(opacity=50); 
 } 

 .sidenav a { 
/     padding: 8px 8px 8px 32px; 
     text-decoration: none; 
     font-size: 25px; 
     color: #818181; 
     display: block; 
     transition: 0.3s; 
 } 
 .sidenav a:hover { 
     color: #f1f1f1; 
     opacity: 0.5; 
     filter: alpha(opacity=50);
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



</style>
</head>
<%@ include file="navbar.jsp"%> 
<body>

 

<!-- <div id="mySidenav" class="sidenav"> -->
<!--   <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> -->
<!--   <a href="index1">Home</a> -->
<!--   <a href="aboutus">About</a> -->
<!--   <a href="#">Services</a> -->
<!--   <a href="#">Clients</a> -->
<!--   <a href="contactus">Contact</a> -->
<!-- </div> -->

<!-- <div id="main"> -->
<!--   <h2>Sidenav Push Example</h2> -->
<!--   <p>Click on the element below to open the side navigation menu, and push this content to the right. Notice that we add a black see-through background-color to body when the sidenav is opened.</p> -->
<!--   <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span> -->
<!-- </div> -->

<script>



// function openNav() {
//     document.getElementById("mySidenav").style.width = "250px";
//     document.getElementById("main").style.marginLeft = "250px";
//     document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
// }

// function closeNav() {
//     document.getElementById("mySidenav").style.width = "0";
//     document.getElementById("main").style.marginLeft= "0";
//     document.body.style.backgroundColor = "white";
// }


</script>










<!-- <marquee behavior="scroll" direction="left"><b>Best Jeans Are Available For This September Month!</b></marquee> -->

<!-- <marquee behavior="alternate" direction="left" bgcolor="#fffff" onmouseover="this.stop()" onmouseout="this.start()" scrollamount="2" scrolldelay="50">Best Jeans Are Available For This September Month!</marquee> -->

<!-- <marquee behavior="scroll" align="middle" direction="left" bgcolor="#ffffff" scrollamount="4" onmouseover="this.stop()" onmouseout="this.start()"><a href="getAllProductsOfOffer">Best Jeans Are Available For This September Month! Click Here!!!</a></marquee> -->

	
<!-- 	<h2 id="getAllProductsOfOffer"></h2> -->
	
	
<!-- 	<h2 id="getAllProductsForMen"></h2> -->
<!-- 	<h2 id="getAllProductsForWomen"></h2> -->
	
	
	<div class="row"
		style="padding: 50px 50px; margin-bottom: 20px">
		<c:forEach items="${products}" var="prod">
			<!-- 	<div class="w3-row-padding" style="padding:50px 50px; margin-bottom: 20px"> -->

			<div class="column">
				<a href="getProductById?id=${prod.productId}">
		 		<img src="<c:url value="/resource/images/products/${prod.productId}.jpg"/>"   
					alt="Norway"   class="img-thumbnail" opacity: "0.5" style="width: 80%" height="360" hspace="50"  ;
					class="w3-hover-opacity"> 
					</a> 
				<div class="w3-container w3-white"  align="center">
					<p>
				<h5 align="center" style='font-family:Verdana;'><b>${prod.productName}</b></h5>
					
<%-- 					<security:authorize ifAnyGranted="ROLE_ADMIN"> --%>
<%-- 					<h5 href="getProductById/${prod.productId}"   ng-controller="myController"> --%>
<%-- 						${prod.productDescription} --%>
<%-- 						</security:authorize></h5> --%>
						
			 <h4>
				 <span style='font-family:Arial;'><strike>&#8377;${prod.originalPrice}</strike></span>&nbsp;&nbsp;
				 <span style='font-family:Arial;'>&#8377; ${prod.productPrice}	&nbsp;
			</h4>
			
				<h3 align="center">
				
				
				
				<a href="cart/add/${prod.productId}"
									class="btn btn-primary" style="margin-left: 5px"> <span
									class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
				&nbsp;
				
				
				
				
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				 	<a href="getProductById/${prod.productId}" 
							class="btn btn-info"  role="button">  <span
								class="glyphicon glyphicon-info-sign"></span></a> <!-- 						view only for user -->
							
								
							
								<a href="admin/product/editProduct/${prod.productId}"
									class="btn btn-success" style="margin-left: 5px"> <span
									class="glyphicon glyphicon-edit"></span></a>
								<a href="admin/delete/${prod.productId}" class="btn btn-danger"
									style="margin-left: 5px"> <span
									class="glyphicon glyphicon-trash"></span></a>
							</security:authorize></h3>
					</ul>
	
					
				</div>
	
			</div>

		</c:forEach>
<!-- <h2 id="getAllProductsForKids"></h2> -->
	</div>
	
	<div>
	
	
	<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>

<!-- <div style="background-color:black;color:white;padding:30px">Scroll Down</div> -->
<!-- <div style="background-color:lightgrey;padding:30px 30px 2500px">This example demonstrates how to create a "scroll to top" button that becomes visible when the user starts to scroll the page.</div> -->

<script>
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("myBtn").style.display = "block";
    } else {
        document.getElementById("myBtn").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
</script>
	
	
</div>



    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
                $(this).toggleClass('active');
            });
        });
    </script>



</body>

</html>