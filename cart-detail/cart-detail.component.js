'use strict';

angular.module('cartDetail').
component('cartDetail',{
    templateUrl: "cart-detail/cart-detail.template.html",
    controller: ['$http','$scope',function CartDetailController($http,$scope){

        var self = this;
        $http.get('http://localhost:3000/cart').then(function(response){
            self.items = response.data;
            var item;
            self.totalPrice=0;
            self.cartCount = self.items.length;
            for(item in self.items){
                self.totalPrice += self.items[item].price * self.items[item].count;  
            }
        });

        $http.get('http://localhost:3000/products').then(function(response){
            self.products = response.data;
        });

        $scope.removeItem = function(item){
            item.count--;
            if (item.count == 0) {
             self.products.forEach(function(product){
                if(item.id === product.id){
                    product.showAddToCart = true;
                    $http.put('http://localhost:3000/products/' + product.id,product);
                }     
            });
                $http.put('http://localhost:3000/products/' + self.products.id,self.products);
                $http.delete('http://localhost:3000/cart/' + item.id,item);
            }else{
                $http.put('http://localhost:3000/cart/' + item.id,item);
            }
            window.location.reload();
        };

        $scope.addItem=function(item){
            item.count++;
            $http.put('http://localhost:3000/cart/' + item.id,item);
            window.location.reload();
        };

        $scope.deleteAll=function(){
            var item = 1;
            var product = 1;
            for(product in self.products){
                self.products[product].showAddToCart = true;
                $http.put('http://localhost:3000/products/' + self.products[product].id, self.products[product]);
            }
            for(item in self.items){
                $http.delete('http://localhost:3000/cart/' + self.items[item].id, item);
            }
            window.location.reload();
        }

        $scope.getCartCount = function() {
            return self.items.length;
        }
    }]
});