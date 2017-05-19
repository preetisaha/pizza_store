var app = angular.module('myApp');
app.controller('trackOrderCtrl', [ '$scope', '$routeParams', '$http','$location', 'dataService',
		function($scope, $routeParams, $http, $location, dataService) {
		$scope.order_no = dataService.order_no;
		
		$scope.confirmClr = "notDone";
		$scope.processClr = "notDone";
		$scope.qualityClr = "notDone";
		$scope.dispatchClr = "notDone";
		$scope.deliveryClr = "notDone";
		
		var socket = new SockJS('/gs-guide-websocket');
		
		stompClient = Stomp.over(socket);
		
		stompClient.connect({}, function(frame){
			console.log('connected: ' + frame);
			stompClient.subscribe('/topic/orderStatus-' + dataService.user_id, function(event){
				var orderStatus = event.body;
				
				if (orderStatus == 1) {
					$scope.confirmClr = "done";
				} else if (orderStatus == 2) {
					$scope.processClr = "done";
				} else if (orderStatus == 3) {
					$scope.qualityClr = "done";
				} else if (orderStatus == 4) {
					$scope.dispatchClr = "done";
				} else if (orderStatus == 5) {
					$scope.deliveryClr = "done";
				}
				
				if(!$scope.$$phase) {
					$scope.$apply();
				}
			})
		});
	
}]);