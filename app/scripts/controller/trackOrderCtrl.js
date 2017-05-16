var app = angular.module('myApp');
app.controller('trackOrderCtrl', [ '$scope', '$routeParams', '$http','$location', 'dataService',
		function($scope, $routeParams, $http, $location, dataService) {
		$scope.order_no = dataService.Order_no;
	
}]);