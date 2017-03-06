app.controller('DesafioController', function($scope, $http, service) {
	var url = location.origin = "http://localhost:8080/desafio/";
	
	$scope.subList = [];
	$scope.listProducts = [];
	
	$scope.loadProduct = function(){
		$http({
			url: url + "rest/product/load",
			method: "GET"
		}).then(function successCallback(response){
			$scope.subList = response.data;
			$scope.listProducts = response.data;
			
			service.set($scope.subList );
			service.set($scope.listProducts );
			
		}, function errorCallback(response) {
			console.log(response);
		})	
	}

	$scope.loadProduct();


});