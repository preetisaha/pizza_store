var app = angular.module('myApp');
app.controller('employeeLoginCtrl', ['$scope','$routeParams','$http','$location','dataService',
		function($scope, $routeParams, $http, $location, dataService) {

			$scope.employeelogin = function() {

				function loginSuccess(response) {
					$scope.name = response.data.name;
					$scope.email = response.data.email;
					$scope.employee_id = response.data.employee_id;
					
					$location.path("pullJob");
				}

				function loginFailure(response) {
					alert("Login Failure");
				}

				var data = {
					email : $scope.email,
					password : $scope.password
				}

				$http.post("employeeLogin", data).then(loginSuccess, loginFailure);
			}

		} ]);
