var app = angular.module('myApp');

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "views/login.html",
        controller : "loginCtrl"
    })
    .when ("/selectPizza",{
    	templateUrl : "views/selectPizza.html",
        controller : "selectPizzaCtrl"
    })
    .when ("/selectSizeAndTopping",{
    	templateUrl : "views/selectSizeAndTopping.html",
        controller : "selectSizeAndToppingCtrl"
    })
    
    .when ("/makePayment",{
    	templateUrl : "views/makePayment.html",
        controller : "makePaymentCtrl"
    })
    
    .when ("/trackOrder",{
    	templateUrl : "views/trackOrder.html",
        controller : "trackOrderCtrl"
    })
    
    .when ("/employeeLogin",{
    	templateUrl : "views/employeeLogin.html",
        controller : "employeeLoginCtrl"
    })
    
    .when ("/pullJob",{
    	templateUrl : "views/pullJob.html",
        controller : "pullJobCtrl"
    })
    
    .when ("/executeOrder",{
    	templateUrl : "views/executeOrder.html",
        controller : "executeOrderCtrl"
    })
});