var app = angular.module('myApp');
app.controller('loginCtrl', [ '$scope', '$routeParams', '$http', '$location', 'dataService', '$timeout',
		function($scope, $routeParams, $http, $location, dataService, $timeout) {
			$scope.loginAlertMessage = true;
			$scope.demoMsg = false;
			$timeout(function () { $scope.demoMsg = true; }, 4000);
			
			$scope.login = function() {
				
				function success(response) {
					dataService.name = response.data.name;
					dataService.email = response.data.email;
					dataService.user_id = response.data.userId;
					$location.path("selectPizza");
				}
				
				function failure (response) {
					$scope.loginAlertMessage = false;
					$timeout(function () { $scope.loginAlertMessage = true; }, 3000);
				}
				
				var data = {
						email: $scope.email,
						password: $scope.password,
				}
				
				$http.post("login", data).then(success, failure);
			}
			
			$scope.employeeLogin = function() {
				$location.path("employeeLogin");
			}

		} ]);
