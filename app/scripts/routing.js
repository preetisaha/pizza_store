var app = angular.module('myApp');

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "views/login.html",
        controller : "myCtrl"
    })
    
});