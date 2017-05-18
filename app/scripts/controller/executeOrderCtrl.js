var app = angular.module('myApp');
app.controller('executeOrderCtrl', ['$scope','$routeParams','$http','$location','dataService',
		function($scope, $routeParams, $http, $location, dataService) {
			$scope.order_no = dataService.employeePulledOrder.order_no;
			$scope.uid = dataService.employeePulledOrder.uid;
			$scope.pizza_price = dataService.employeePulledOrder.pizza_price;
			
			$scope.coButtonColor = "info";
			$scope.poButtonColor = "info";
			$scope.qcButtonColor = "info";
			$scope.doButtonColor = "info";
			$scope.dlButtonColor = "info";
			
			$scope.coDisabled = false;
			$scope.poDisabled = false;
			$scope.qcDisabled = false;
			$scope.doDisabled = false;
			$scope.dlDisabled = false;
			
			$scope.execute = function(orderSts) {
				
				function executeSuccess(response) {
					if (orderSts == 1) {
						$scope.coButtonColor = "success";
						$scope.coDisabled = true;
					} else if (orderSts == 2) {
						$scope.poButtonColor = "success";
						$scope.poDisabled = true;
					} else if (orderSts == 3) {
						$scope.qcButtonColor = "success";
						$scope.qcDisabled = true;
					} else if (orderSts == 4) {
						$scope.doButtonColor = "success";
						$scope.doDisabled = true;
					} else if (orderSts == 5) {
						$scope.dlButtonColor = "success";
						$scope.dlDisabled = true;
					}
					
					if(!$scope.$$phase) {
						$scope.$apply();
					}
				}
				
				function executeError(response) {
					alert("Error");
				}
				
				var data = {
						userId: $scope.uid,
						orderNumber: $scope.order_no,
						orderStatus: orderSts	
				}
				
				$http.put("orderUpdate/", data).then(executeSuccess, executeError);
			}
		} 
]);