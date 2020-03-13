<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<%@ include file="navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="icon" type="image/x-icon"
	href="<c:url value="/resource/images/favicon1.png"/>" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resource/js/productController.js"/>"></script>
<style>
* {box-sizing: border-box;}

.img-zoom-container {
  position: relative;
}

.img-zoom-lens {
  position: absolute;
  border: 1px solid #d4d4d4;
  /*set the size of the lens:*/
  width: 40px;
  height: 40px;
}

.img-zoom-result {
  border: 1px solid #d4d4d4;
  /*set the size of the result div:*/
  width: 300px;
  height: 300px;
}

</style>	   
</head>
<body>
<script>
function imageZoom(imgID, resultID) {
	  var img, lens, result, cx, cy;
	  img = document.getElementById(imgID);
	  result = document.getElementById(resultID);
	  /*create lens:*/
	  lens = document.createElement("DIV");
	  lens.setAttribute("class", "img-zoom-lens");
	  /*insert lens:*/
	  img.parentElement.insertBefore(lens, img);
	  /*calculate the ratio between result DIV and lens:*/
	  cx = result.offsetWidth / lens.offsetWidth;
	  cy = result.offsetHeight / lens.offsetHeight;
	  /*set background properties for the result DIV*/
	  result.style.backgroundImage = "url('" + img.src + "')";
	  result.style.backgroundSize = (img.width * cx) + "px " + (img.height * cy) + "px";
	  /*execute a function when someone moves the cursor over the image, or the lens:*/
	  lens.addEventListener("mousemove", moveLens);
	  img.addEventListener("mousemove", moveLens);
	  /*and also for touch screens:*/
	  lens.addEventListener("touchmove", moveLens);
	  img.addEventListener("touchmove", moveLens);
	  function moveLens(e) {
	    var pos, x, y;
	    /*prevent any other actions that may occur when moving over the image*/
	    e.preventDefault();
	    /*get the cursor's x and y positions:*/
	    pos = getCursorPos(e);
	    /*calculate the position of the lens:*/
	    x = pos.x - (lens.offsetWidth / 2);
	    y = pos.y - (lens.offsetHeight / 2);
	    /*prevent the lens from being positioned outside the image:*/
	    if (x > img.width - lens.offsetWidth) {x = img.width - lens.offsetWidth;}
	    if (x < 0) {x = 0;}
	    if (y > img.height - lens.offsetHeight) {y = img.height - lens.offsetHeight;}
	    if (y < 0) {y = 0;}
	    /*set the position of the lens:*/
	    lens.style.left = x + "px";
	    lens.style.top = y + "px";
	    /*display what the lens "sees":*/
	    result.style.backgroundPosition = "-" + (x * cx) + "px -" + (y * cy) + "px";
	  }
	  function getCursorPos(e) {
	    var a, x = 0, y = 0;
	    e = e || window.event;
	    /*get the x and y positions of the image:*/
	    a = img.getBoundingClientRect();
	    /*calculate the cursor's x and y coordinates, relative to the image:*/
	    x = e.pageX - a.left;
	    y = e.pageY - a.top;
	    /*consider any page scrolling:*/
	    x = x - window.pageXOffset;
	    y = y - window.pageYOffset;
	    return {x : x, y : y};
	  }
	}

</script>
	<div ng-app="myapp">
		<div class="container" style="width: 829px">
			<h2>Product Details</h2>
			<p>Details of the Product</p>
			<table class="table table-bordered" id="prod">
				<tbody>

					<tr>
						<td>Prodcut Image</td>
						<td>
						<div class="img-zoom-container">
						<img
						id="myimage"	src="<c:url value="/resource/images/products/${productObj.productId}.jpg"/>"
							width="40%" alt="${productObj.productName}"/>
							
						</div> </td>
						<td> <div id="myresult" class="img-zoom-result"></div></td>
						<script>
						imageZoom("myimage", "myresult");
					  </script>
							
  
 					</tr>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<tr>
						<td>Prodcut ID</td>
						<td>${productObj.productId }</td>
					</tr>
					</security:authorize>
					<tr>
						<td>Product Name</td>
						<td>${productObj.productName }</td>
					</tr>
					<tr>
						<td>Product Category</td>
						<td>${productObj.productCategory}</td>
					</tr>
					<tr>
						<td>Product Description</td>
						<td>${productObj.productDescription}</td>
					</tr>
					<tr>
						<td>Product Manufacturer</td>
						<td>${productObj.productManufacturer}</td>
					</tr>
					<tr>
						<td>Product Price</td>
						<td>${productObj.productPrice}</td>
					</tr>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<tr>
						<td>Stock Available</td>
						<td>${productObj.unitStock}</td>
					</tr>
					</security:authorize>
					<tr>
						<td>Add to Cart:</td>
						<td><c:url value="/cart/add/${productObj.productId}"
								var="addcart"></c:url>
							<div ng-controller="myController">
							<%-- 	<security:authorize access="hasRole('ROLE_USER\')"> --%>
									<a href="addToCart(${productObj.productId})"
										class="btn btn-info"
										style="margin-top: 0px; width: 150px; float: left; margin-right: 31px;">
										<span class="glyphicon glyphicon-shopping-cart"></span>
									</a>
						<%-- 		</security:authorize> --%>
								<%-- <a href="<c:url value="/getAllProducts" />" class="btn btn-info"
									style="margin-top: 0px; width: 150px; float: right; margin-right: 31px;">
									<span class="glyphicon glyphicon-arrow-left"></span>
								</a> --%>
							</div></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>
