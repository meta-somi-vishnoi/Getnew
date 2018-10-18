'use strict';

angular.module('orders').
    component('orders',{
        templateUrl:"orders/orders.template.html",
        controller:['$http','$scope',function OrdersController($http,$scope){
            var self=this;
            $http.get('http://localhost:3000/orders').then(function(response){
                self.orders = response.data;
            });

            $scope.getOrder=function(orderId){
                $http.get('http://localhost:3000/orders/'+ orderId).then(function(response){
                    self.items = response.data.items;
                    var item;
                    self.totalPrice=0;
                    for(item in self.items){
                        self.totalPrice += self.items[item].price;  
                    }
                });
            }
        }]
    });