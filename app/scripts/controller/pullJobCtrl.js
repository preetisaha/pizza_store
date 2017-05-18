var app = angular.module('myApp');
app.controller('pullJobCtrl', ['$scope','$routeParams','$http','$location','dataService',
		function($scope, $routeParams, $http, $location, dataService) {
			$scope.newOrder = 0;
			
			var socket = new SockJS('/gs-guide-websocket');
			
			stompClient = Stomp.over(socket);
			
			stompClient.connect({}, function(frame){
				console.log('connected: ' + frame);
				stompClient.subscribe('/topic/newOrders', function(newOrderCount){
					$scope.newOrder = newOrderCount.body;
					$scope.$apply();
				})
			});
			
			$scope.pullJob = function() {
				
				function pullJobSuccess(response) {
					dataService.employeePulledOrder = response.data;
					$location.path("executeOrder");
				}
				
				function pullJobError(response) {
					alert("error");
				}
				
				$http.get("pullOrder/" + dataService.employee_id).then(pullJobSuccess, pullJobError);
			}
} ]);