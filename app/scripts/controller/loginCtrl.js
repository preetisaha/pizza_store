var app = angular.module('myApp');
app.controller('loginCtrl', [ '$scope', '$routeParams', '$http', '$location', 'dataService',
		function($scope, $routeParams, $http, $location, dataService) {
	
			$scope.login = function() {
				
				function success(response) {
					dataService.name = response.data.name;
					dataService.email = response.data.email;
					dataService.user_id = response.data.userId;
					$location.path("selectPizza");
				}
				
				function failure (response) {
					alert("hello");
				}
				
				var data = {
						email: $scope.email,
						password: $scope.password,
				}
				
				$http.post("login", data).then(success, failure);
			}

		} ]);
