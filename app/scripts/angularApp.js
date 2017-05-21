var app = angular.module("myApp", [ "ngRoute", "credit-cards" ]).filter(
		'yesNo', function() {
			return function(boolean) {
				return boolean ? 'Yes' : 'No';
			}
		});