
app.controller('DesafioController', ['$scope','ProductService', '$mdDialog','$timeout', function($scope, ProductService, $mdDialog, $timeout) {
	
	$scope.openModal = function (event) {
	    $mdDialog.show({
	      clickOutsideToClose: true,
	      controllerAs: 'product',
	      focusOnOpen: false,
	      targetEvent: event,
	      templateUrl: 'product/modalProduct.html',
	    }).then($scope.getDesserts);
	  };

	
	//Função de adicionar novos usuario
	$scope.addProduct = function (data) {
		ProductService.postProduct(data, function (response) {
			//ToastService.alert('Usuario adicionada com sucesso!', undefined, 'bottom left', 3000);
			
		}),
			function (error) {
	
			};
	};


}]);