'use strict';

angular.module('shippingDetail').
component('shippingDetail',{
    templateUrl:"shipping-detail/shipping-detail.template.html",
    controller:['$http','$scope',function ShippingDetailController($http,$scope){

        var self = this;
        $http.get('http://localhost:3000/cart').then(function(response){
            self.items = response.data;
            var item;
            self.totalPrice=0;
            for(item in self.items){
                self.totalPrice += self.items[item].price * self.items[item].count;  
            }
        });

        $http.get('http://localhost:3000/shipping').then(function(response){
            self.shipping = response.data;
        });

        $scope.placeOrder=function(){
            $http.get('http://localhost:3000/products/').then(function(response){
                self.productList = response.data;
                self.productList.forEach(function(product){
                    product.showAddToCart = true;
                    $http.put('http://localhost:3000/products/' + product.id,product);
                });
            });
            $http({
                method:'PUT',
                data:self.shipping[0],
                url:'http://localhost:3000/shipping/'+self.shipping[0].id,
                dataType:'json'
            }).then(function(response){
                console.log("successfull");
            });
            $http.get('http://localhost:3000/cart').then(function(response){
                self.items = response.data;
            });
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth()+1;
            var yyyy = today.getFullYear();
            today = mm + '/' + dd + '/' + yyyy;
            var orderData={
                "items":self.items,
                "customerName":self.shipping[0].name,
                "date":today
            }
            $http({
                method:'POST',
                url:'http://localhost:3000/orders',
                data:orderData,
                dataType:'json'
            });
            var item=1;
            for(item in self.items){
                $http.delete('http://localhost:3000/cart/' + self.items[item].id, item).then(function(response){
                })
            }
            window.location="#!/products/order-success/";   
        }
    }]
});