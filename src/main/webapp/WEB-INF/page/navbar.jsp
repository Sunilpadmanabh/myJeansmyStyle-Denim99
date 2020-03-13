<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->




<style>
.sunil {
	color: white;
	font-family: Comic Sans MS;
	transition: 0.9s;
}

#Denim-navbar {
	height: 165px;
	background-color: blue;
	/* For browsers that do not support gradients */
	background-image: linear-gradient(to bottom right, blue, #01FF70);
	/* Standard syntax (must be last) */
	color: #FFFFFF;
}

.row1 {
	padding-top: 50px;
}

.row2 {
	padding-bottom: 50px;
}

.Denim-navbar-input {
	padding: 11px 16px;
	border-radius: 2px 0 0 2px;
	border: 0 none;
	outline: 0 none;
	font-size: 15px;
	color: black;
}

.Denim-navbar-button {
	background-color: #808080;
	border: 1px solid #808080;
	border-radius: 0 2px 2px 0;
	color: #FFDC00;
	padding: 10px 0;
	height: 43px;
	cursor: pointer;
}

.cart-button {
	background-color: #808080;
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .23), inset 1px 1px 0 0
		hsla(0, 0%, 100%, .2);
	padding: 10px 0;
	text-align: center;
	height: 41px;
	border-radius: 2px;
	font-weight: 500;
	width: 120px;
	display: inline-block;
	color: #FFFFFF;
	text-decoration: none;
	color: inherit;
	border: none;
	outline: none;
}

.cart-button:hover {
	text-decoration: none;
	color: #fff;
	cursor: pointer;
}

.cart-svg {
	display: inline-block;
	width: 16px;
	height: 16px;
	vertical-align: middle;
	margin-right: 8px;
}

.item-number {
	border-radius: 3px;
	background-color: rgba(0, 0, 0, .1);
	height: 20px;
	padding: 3px 6px;
	font-weight: 500;
	display: inline-block;
	color: #fff;
	line-height: 12px;
	margin-left: 10px;
}

.upper-links {
	display: inline-block;
	padding: 0 10px;
	line-height: 23px;
	font-family: 'Roboto', sans-serif;
	letter-spacing: 0;
	color: inherit;
	border: none;
	outline: none;
	font-size: 12px;
}

.dropdown {
	position: fixed;
	display: inline;
	margin-bottom: 0px;
}

.dropdown:hover {
	background-color: #fff;
}

.dropdown:hover .links {
	color: #fff;
}

.dropdown:hover .dropdown-menu {
	display: block;
}

.dropdown .dropdown-menu {
	position: absolute;
	top: 100%;
	display: none;
	background-color: #fff;
	color: #333;
	left: 0px;
	border: 0;
	border-radius: 0;
	box-shadow: 0 4px 8px -3px #555454;
	margin: 0;
	padding: 0px;
}

.links {
	color: #fff;
	text-decoration: none;
}

.links:hover {
	color: #fff;
	text-decoration: none;
}

.profile-links {
	font-size: 12px;
	font-family: 'Roboto', sans-serif;
	border-bottom: 1px solid #e9e9e9;
	box-sizing: border-box;
	display: block;
	padding: 0 11px;
	line-height: 23px;
}

.profile-li {
	padding-top: 2px;
}

.largenav {
	display: none;
}

.smallnav {
	display: block;
}

.smallsearch {
	margin-left: 15px;
	margin-top: 15px;
}

xd
.menu {
	cursor: pointer;
}

@media screen and (min-width: 768px) {
	.largenav {
		display: block;
	}
	.smallnav {
		display: none;
	}
	.smallsearch {
		margin: 0px;
	}
}

.dropdown-content a {
	color: #326EC4;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	font-family: Courier New;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropbtn {
	font-size: 12px;
	color: #326EC4;
	font-weight: 1400; /
	text-indent: 0em; /
	font-family: Courier New;
	text-align: middle;
	background-color: white;
	color: blue; /
	padding: 16px;
	font-size: 20px;
	border: none;
	cursor: pointer;
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

#login-dp {
	min-width: 250px;
	padding: 14px 14px 0;
	overflow: hidden;
	background-color: rgba(255, 255, 255, .8);
}

#login-dp .help-block {
	font-size: 12px
}

#login-dp .bottom {
	background-color: rgba(255, 255, 255, .8);
	border-top: 1px solid #ddd;
	clear: both;
	padding: 14px;
}

#login-dp .social-buttons {
	margin: 12px 0
}

#login-dp .social-buttons a {
	width: 49%;
}

#login-dp .form-group {
	margin-bottom: 10px;
}

.btn-fb {
	color: #fff;
	background-color: #3b5998;
}

.btn-fb:hover {
	color: #fff;
	background-color: #496ebc
}

.btn-tw {
	color: #fff;
	background-color: #55acee;
}

.btn-tw:hover {
	color: #fff;
	background-color: #59b5fa;
}

@media ( max-width :768px) {
	#login-dp {
		background-color: inherit;
		color: #fff;
	}
	#login-dp .bottom {
		background-color: inherit;
		border-top: 0 none;
	}
}
</style>

<style>
function
 
openNav
 
()
{
document

	
.getElementById
("mySidenav")
.style
.width
="70%";
//
 
document

	
.getElementById
("Denim-navbar")
.style
.width
="50%";document

	
.body
.style
.backgroundColor
="rgba(0
,
0,0,0
.4
)";

	

}
function
 
closeNav
 
()
{
document

	
.getElementById
("mySidenav")
.style
.width
="0";document

	
.body
.style
.backgroundColor
="rgba(0
,
0,0,0)";
}
</style>







<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/overall.css"/>">

<div id="Denim-navbar">
	<div class="container">
		<div class="row row1">
			<ul class="largenav pull-right">
				<c:if test="${!empty pageContext.request.userPrincipal.name}">
					<li class="dropdown"><a class="links">Welcome:${currentUser}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
						<ul class="w3-bar w3-black">
							<li class="profile-li"><a
								href=" <c:url value="/userdetails" />">MyAccount</a> <a
								href=" <c:url value="cart/getCartById" />">MyOrders</a> <a
								href=" <c:url value="/j_spring_security_logout" />">Logout</a>
						</ul></li>
				</c:if>

				<c:if test="${pageContext.request.userPrincipal.name==null}">
					<!-- <li class="upper-links"><a class="links" href="login">Login
					</a></li> -->
					<li class="dropdown"><a href="login" class="sunil"
						data-toggle="dropdown">Login<span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								<div class="row">
									<div class="col-md-12">
										<!-- 										Login via -->
										<!-- 										<div class="social-buttons"> -->
										<!-- 											<a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> -->
										<!-- 												Facebook</a> <a href="#" class="btn btn-tw"><i -->
										<!-- 												class="fa fa-twitter"></i> Twitter</a> -->
										<!-- 										</div> -->

										<form class="form" role="form" method="post"
											action="<c:url value="/j_spring_security_check"/>"
											accept-charset="UTF-8" id="login-nav">
											<div class="form-group">
												<label class="sr-only" for="exampleInputEmail2">Email
													address</label> <input type="email" name="j_username"
													class="form-control" id="exampleInputEmail2"
													placeholder="Email address" required>
											</div>
											<div class="form-group">
												<label class="sr-only" for="exampleInputPassword2">Password</label>
												<input type="password" name="j_password"
													class="form-control" id="exampleInputPassword2"
													placeholder="Password" required>
												<div class="help-block text-right">
													<a href="forgotpassword">Forget the password ?</a>
												</div>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary btn-block">Sign
													in</button>
											</div>
											<div class="checkbox">
												<!-- 												<label> <input type="checkbox"> keep me -->
												<!-- 													logged-in -->
												<!-- 												</label> -->
											</div>
										</form>
									</div>
									<div class="bottom text-center">
										New here ? <a href="registration"><b>Join Us</b></a>
									</div>
								</div>
							</li>
						</ul></li>
					<li class="upper-links"><a class="links" href="registration">Signup</a></li>

				</c:if>
				<!--                 <li class="upper-links"> -->
				<!--                     <a class="links" href="http://clashhacks.in/"> -->
				<!--                         <svg class="" width="16px" height="12px" style="overflow: visible;"> -->
				<!--                             <path d="M8.037 17.546c1.487 0 2.417-.93 2.417-2.417H5.62c0 1.486.93 2.415 2.417 2.415m5.315-6.463v-2.97h-.005c-.044-3.266-1.67-5.46-4.337-5.98v-.81C9.01.622 8.436.05 7.735.05 7.033.05 6.46.624 6.46 1.325v.808c-2.667.52-4.294 2.716-4.338 5.98h-.005v2.972l-1.843 1.42v1.376h14.92v-1.375l-1.842-1.42z" fill="#fff"></path> -->
				<!--                         </svg> -->
				<!--                     </a> -->
				<!--                 </li> -->
				<li class="dropdown"><a class="links">Product category</a>
					<ul class="dropdown-menu">
						<li class="w3-bar-item w3-button"><a
							href=" <c:url value="/getAllProductsForMen" />">Men</a> <a
							href=" <c:url value="/getAllProductsForWomen" />">Women</a> <a
							href=" <c:url value="/getAllProductsForKids" />">Kids</a>
					</ul></li>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="upper-links"><a class="links"
						href=" <c:url value="/admin/product/addProduct" />">Add
							Product</a></li>
				</security:authorize>
			</ul>

			<br> <br>


			<!-- 			Only admin can view this link -->

			</ul>

			<br>
		</div>
		<div class="row row2">
			<div class="col-sm-2">
				<h2 style="margin: 0px;">
					<a class="sunil" href="index1" class="smallnav menu"
						onclick="openNav()" title="Denim99!"> Denim99</a>
				</h2>
				<!-- 				<h1 style="margin: 0px;"> -->
				<!-- 					<a color="white" href="index1" class="largenav">Denim99</a> -->
				<!-- 				</h1> -->
			</div>
			
			
			<div class="Denim-navbar-search smallsearch col-sm-8 col-xs-11">
				<div class="row">
					<form action="search">
						<input class="Denim-navbar-input col-xs-11" type=""
							placeholder="Search for Products, Denim99s and more" name="searchtext" id="searchtext">
						<button class="Denim-navbar-button col-xs-1">
							<svg width="15px" height="15px">
                            <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                        </svg>
						</button>
					</form>
				</div>
			</div>
			
			
			<div class="cart largenav col-sm-2">
				<a class="cart-button" href="cart/getCartById"> <svg
						class="cart-svg " width="16 " height="16 " viewBox="0 0 16 16 ">
                        <path
							d="M15.32 2.405H4.887C3 2.405 2.46.805 2.46.805L2.257.21C2.208.085 2.083 0 1.946 0H.336C.1 0-.064.24.024.46l.644 1.945L3.11 9.767c.047.137.175.23.32.23h8.418l-.493 1.958H3.768l.002.003c-.017 0-.033-.003-.05-.003-1.06 0-1.92.86-1.92 1.92s.86 1.92 1.92 1.92c.99 0 1.805-.75 1.91-1.712l5.55.076c.12.922.91 1.636 1.867 1.636 1.04 0 1.885-.844 1.885-1.885 0-.866-.584-1.593-1.38-1.814l2.423-8.832c.12-.433-.206-.86-.655-.86 "
							fill="#fff "></path>
                    </svg> My Cart <span class="item-number">${itemcount}</span>
				</a>
			</div>
		</div>
	</div>
</div>
<!-- <div id="mySidenav" class="sidenav"> -->
<!-- 	<div class="container" -->
<!-- 		style="background-color: #2874f0; padding-top: 10px;"> -->
<!-- 		<span class="sidenav-heading">Home</span> <a href="javascript:void(0)" -->
<!-- 			class="closebtn" onclick="closeNav()">×</a> -->
<!-- 	</div> -->
<!-- 	<a href="#">Link</a> <a href="#">Link</a> <a href="#">Link</a> <a -->
<!-- 		href="#">Link</a> -->
<!-- </div> -->


<script type="text/javascript">

function search(){
	window.open("search/"+document.getElementById("searchtext").value);
}
</script>
