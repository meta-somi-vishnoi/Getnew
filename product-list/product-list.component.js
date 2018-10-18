'use strict';

angular.module('productList').
component('productList',{
  templateUrl: 'product-list/product-list.template.html',
  controller: function ProductsController($scope,$http,$rootScope){
    var self = this;
    $rootScope.cartCount = 0;
    $http.get('http://localhost:3000/products').then(function(response){
      $scope.products = response.data;
    });
    $http.get('http://localhost:3000/cart').then(function(response){
      $scope.cartList = response.data;
      $rootScope.cartCount = $scope.cartList.length;
    });
    $scope.getCount = function(title){
      var cart = 1;
      for(cart in $scope.cartList){
        if($scope.cartList[cart].title === title){
          return $scope.cartList[cart].count;
        }
      }    
    }

    $scope.removeItem = function(product){
      $http.get('http://localhost:3000/cart/' + product.id).then(function(response){
        $scope.productInformation = response.data;
        $scope.productInformation.count--;
        if ($scope.productInformation.count ==  0) {
          product.showAddToCart = true;
          $http.put('http://localhost:3000/products/' + product.id,product);
          $http.delete('http://localhost:3000/cart/' + $scope.productInformation.id,$scope.productInformation);
        }else{
          $http.put('http://localhost:3000/cart/' + $scope.productInformation.id,$scope.productInformation);
        }
        window.location.reload();
      });
    };

    $scope.addItem=function(product){
      $http.get('http://localhost:3000/cart/' + product.id).then(function(response){
        self.productInformation = response.data;
        self.productInformation.count++;
        $http.put('http://localhost:3000/cart/' + self.productInformation.id,self.productInformation);
        window.location.reload();
      });
    };

    $scope.addToCart=function(product){
      product.showAddToCart = false;
      $http.put('http://localhost:3000/products/' + product.id,product);
      var cartData = {
        "id":product.id,
        "title":product.title,
        "price":product.price,
        "imageUrl":product.imageUrl,
        "count":1,
      }
      $http({
        method: 'POST',
        url:'http://localhost:3000/cart/',
        data: cartData,
        dataType:'json'
      }).then(function successCallback(response){
        window.location.reload();
      });
    }
  }
});