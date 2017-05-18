var app = angular.module('myApp')
    app.service('dataService', function () {
        this.name = null;
        this.email = null;
        this.user_id = null;
        this.selectedTopping = [];
        this.pizza;
        this.order_no;
        this.employee_id = null;
        this.employee_name = null;
        this.employee_email = null;
        this.employeePulledOrder = null;
    });