var app = angular.module('myApp');
app.controller('selectPizzaCtrl', [ '$scope', '$routeParams', '$http', '$location','dataService',
function($scope, $routeParams, $http, $location, dataService) {
	$scope.name = dataService.name;
	$scope.email = dataService.email;
	$scope.user_id = dataService.user_id;
	$scope.pizzaType = function() {
		$location.path("selectSizeAndTopping");
	}
} ]);
