///  Documentação http://embed.plnkr.co/bKJNoG/
app.controller('DesafioController', ['$scope','ProductService', '$mdDialog','$timeout', function($scope, ProductService, $mdDialog, $timeout) {

$scope.isSelected = [];
	
//Abrir Modal
	$scope.openModal = function (event) {
	    $mdDialog.show({
		  controller: ModalController,
		  templateUrl: 'product/modalProduct.html',
		  targetEvent: event,
		  clickOutsideToClose:true,
	      locals : {
              resultModal : $scope
          }
	    }).then($scope.getDesserts);
	  };

	//Busca produtos do banco
	$scope.getProduct = function () {
		ProductService.getProduct(function (response) {
			$scope.listProducts = response.data;
		});

	};
	
	//Chama função para buscar produtos
	$scope.getProduct();
	
	//Controller da modal
	function ModalController($scope, $mdDialog, resultModal) {

		$scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };
		    
		//Função de adicionar novos usuario
		$scope.addProduct = function (data) {
			ProductService.postProduct(data, function (response) {
				$mdDialog.hide(data);
				toastr.success(response.message);
				resultModal.listProducts = response.data;

			}),
				function (error) {
		
				};
		};


	  }

}]);