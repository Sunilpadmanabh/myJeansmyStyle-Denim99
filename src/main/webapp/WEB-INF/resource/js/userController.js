var app = angular.module("userapp", []).controller(
		"userController",
		function($scope, $http) {

			var BASE_PATH = "http://localhost:8080/MyJeansMyStyle";

			$scope.getCurrentUser = function() {
				$http.get(BASE_PATH + "/getCurrentUser").
	            then(function(response) {
	                $scope.currentUser = response.data;
	            });
			}
		});