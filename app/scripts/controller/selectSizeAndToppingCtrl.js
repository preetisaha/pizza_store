var app = angular.module('myApp');
app.controller('selectSizeAndToppingCtrl', [ '$scope', '$routeParams', '$http','$location', 'dataService',
	function($scope, $routeParams, $http, $location, dataService) {
		$scope.totalToppingPrice = 0;
		$scope.selectTopping = function(topping){
			topping.selected = true;
			$scope.totalToppingPrice = $scope.totalToppingPrice + topping.price;
		}
		
		$scope.unSelectTopping = function(topping){
			topping.selected = false;
			$scope.totalToppingPrice = $scope.totalToppingPrice - topping.price;
		}
	
		function pizzaSizeSuccess(response) {
			$scope.pizzaDomain = response.data;
			$scope.pizza=$scope.pizzaDomain[0];
		}
		
		function pizzaSizeFailure(response) {
			alert("error");
		}
		
		$http.get("pizza/").then(pizzaSizeSuccess, pizzaSizeFailure);
		
		function selectToppingSuccess (response){
			$scope.toppingList = response.data;
			
		}
		
		function selectToppingFailure (response){
			alert(" selectToppingFailure error");
			
		}
		
		$http.get("pizzaTopping/").then(selectToppingSuccess, selectToppingFailure);
		
		$scope.checkOut = function(){
			var i =0;
			var selectedTopping = [];
			for(i; i<$scope.toppingList.length; i++){
				if($scope.toppingList[i].selected){
					var topping = $scope.toppingList[i];
					selectedTopping.push(topping);
				}
			}
			dataService.selectedTopping = selectedTopping;
			dataService.pizza = $scope.pizza;
			$location.path("makePayment");
		}
	} 
]);

