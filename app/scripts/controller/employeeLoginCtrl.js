var app = angular.module('myApp');
app.controller('employeeLoginCtrl', ['$scope','$routeParams','$http','$location','dataService','$timeout',
		function($scope, $routeParams, $http, $location, dataService, $timeout) {
			
			$scope.loginAlertMessage = true;
			$scope.demoMsg = false;
			$timeout(function () { $scope.demoMsg = true; }, 4000);
	
			$scope.employeelogin = function() {

				function loginSuccess(response) {
					dataService.employee_name = response.data.name;
					dataService.employee_email = response.data.email;
					dataService.employee_id = response.data.employee_id;
					
					$location.path("pullJob");
				}

				function loginFailure(response) {
					$scope.loginAlertMessage = false;
					$timeout(function () { $scope.loginAlertMessage = true; }, 3000);
				}

				var data = {
					email : $scope.email,
					password : $scope.password
				}

				$http.post("employeeLogin", data).then(loginSuccess, loginFailure);
			}

		} ]);
