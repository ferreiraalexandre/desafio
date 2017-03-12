app.controller('DesafioController', function($scope, $http, service) {
	var url = location.origin = "http://localhost:8080/desafio/";
	
	$scope.subList = [];
	$scope.listProducts = [];
	var teste = [];
	
	$scope.loadProduct = function(){
		$http({
			url: url + "rest/product/listProduct",
			method: "GET"
		}).then(function successCallback(response){
			teste =	response.data;
			for(var x = 0; x <teste.data.length; x++){
				$scope.listProducts.push(teste.data[x]);
				$scope.subList.push(teste.data[x]);
			}
			service.set($scope.listProducts);
			service.set($scope.subList);
		}, function errorCallback(response) {
			console.log(response);
		})	
	}

	$scope.loadProduct();


});