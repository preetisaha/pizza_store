var app = angular.module('myApp');
app.controller('makePaymentCtrl', [ '$scope', '$routeParams', '$http',
		'$location', 'dataService',
		function($scope, $routeParams, $http, $location, dataService) {
			$scope.toppingLst = dataService.selectedTopping;
			
			$scope.toppingIdList = [];
			var i = 0;
			$scope.price = 0;
			for (i; i < $scope.toppingLst.length; i++) {
				var toppingObj = $scope.toppingLst[i];
				$scope.price = $scope.price + toppingObj.price;
				$scope.toppingIdList.push(toppingObj.id);
			}

			$scope.pizza = dataService.pizza;

			$scope.pay = function() {
				function orderNoSuccess(response) {
					dataService.order_no = response.data;
					$location.path("trackOrder");
				}

				function orderNoFailure(response) {
					alert("error");
				}
				
				var data = {
						uid: dataService.user_id,
						pizza_price: dataService.pizza.price,
						toppingIdList: $scope.toppingIdList
				}

				$http.post("order", data).then(orderNoSuccess, orderNoFailure);
				
			}
		} ]);