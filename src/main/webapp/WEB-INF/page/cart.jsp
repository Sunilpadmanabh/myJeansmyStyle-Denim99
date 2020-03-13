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
<title>Cart</title>
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/favicon1.png"/>" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	
<script>
var app = angular.module("myapp", []).controller(
		"myController",
		function($scope, $http) {

			var BASE_PATH = "http://localhost:8080/MyJeansMyStyle";

			$scope.getProductList = function() {
				$http.get(BASE_PATH + "/getProductsList")
						.success(function(data) {
							$scope.products = data;
						});
			}

			$scope.addToCart = function(productId) {
				$http.put(BASE_PATH + "/cart/add/" + productId)
						.success(function() {
						
						})
			}

			$scope.refreshCart = function() {
				if(isNaN($scope.cartId)){
				$http.get(BASE_PATH + "/cart/getCartWithoutLogin/"
								+ $scope.cartId).success(function(data) {

					$scope.carts = data;
				})
				}else{
					$http.get(BASE_PATH + "/cart/getCart/"
							+ $scope.cartId).success(function(data) {

				$scope.carts = data;
			})
				}
			}

			$scope.getCart = function(cartId) {
				$scope.cartId = cartId;
				$scope.refreshCart(cartId);
			}
			$scope.removeFromCart = function(cartItemId) {
				$http.put(BASE_PATH +"/cart/removeCartItem/"
								+ cartItemId).success(function() {
					$scope.refreshCart();
				});
			}

			$scope.clearCart = function() {
				$http.put(BASE_PATH + "/cart/removeAllItems/"
								+ $scope.cartId).success(function() {
					$scope.refreshCart();
				});
			}

			$scope.calculateGrandTotal = function() {
				var grandTotal = 0.0;
				for (var i = 0; i < $scope.carts.cartItem.length; i++)
					grandTotal = grandTotal + $scope.carts.cartItem[i].price;
				return grandTotal;

			}
		});
</script>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container"
		style="width: 1145px; margin-top: 20px; margin-bottom: 180px;">
		<div ng-app="myapp" ng-controller="myController"
			style="margin-bottom: 30px">
			<div ng-init="getCart(${cartId})">
				<br> List of Products Purchased
				<div>

					<a class="btn btn-danger pull-left" ng-click="clearCart()"
						style="margin-top: 15px; margin-left: 20px"> <span
						class="glyphicon glyphicon-remove-sign"> </span>Clear Cart
					</a>
				</div>
				<div>
					<c:url value="/order/${cartId}" var="url1"></c:url>
					<a href="buynow" class="btn btn-danger pull-left"
						style="margin-top: 15px; margin-left: 20px"> <span
						class="glyphicon glyphicon-shipping-cart"> </span>Buy Now
					</a>
				</div>
				<table class="table table-hover" id="productList">
					<thead>
						<tr>
						    <th>Product Image</th>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Total Price</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="cart in carts.cartItem">
						<td style="width: 171px">
							<img src="<c:url value="/resource/images/products/{{cart.product.productId}}.jpg"/>"
								style="width: 100px; height: 90px;"/></td>
							<td>{{cart.product.productName}}</td>
							<td>{{cart.quality}}</td>
							<td>{{cart.product.productPrice}}</td>
							<td>{{cart.price}}</td>
							<td><a href="#" class="btn btn-danger"
								ng-click="removeFromCart(cart.cartItemId)"
								style="margin-top: 0px;"><span
									class="glyphicon glyphicon-trash"></span>remove</a></td>
					</tbody>
				</table>
				Grand Total Price: {{calculateGrandTotal()}}
			</div>
			<c:url value="/index1" var="url"></c:url>
			<a href="${url}" class="btn btn-default" style="margin-left: 20px">Continue
				Shopping</a>
		</div>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>