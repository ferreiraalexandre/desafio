///  Documentação http://embed.plnkr.co/bKJNoG/
app.controller('DesafioController', ['$scope','ProductService', '$mdDialog','$timeout', 'toastr',
                             function($scope,  ProductService,   $mdDialog,  $timeout,   toastr) {
	$scope.selected = [];
	$scope.isLoading = true;
    $scope.buttonAddDisabled = false;
	$scope.buttonEditDisabled = true;
	$scope.buttonRemoveDisabled = true;
		
	$scope.takeProduct = function (product) {
	    //console.log(numero_contrato);
	    var index = $scope.selected.indexOf(product);

	    // se já selecionou o contrato, então remove (nesse caso o checkbox foi desmarcado)
	    if (index > -1)
	        $scope.selected.splice(index, 1);
	    // se selecionou um novo contrato, adiciona ao array
	    else
	      $scope.selected.push(product);
	      console.log($scope.selected);
	      $scope.buttonAddDisabled = $scope.selected.length > 1;
	      $scope.buttonEditDisabled = !($scope.selected.length == 1);
	      $scope.buttonRemoveDisabled = $scope.selected.length == 0;

	}
	
//Abrir Modal
	$scope.openModal = function (event, type) {
	    $mdDialog.show({
		  controller: ModalController,
		  templateUrl: 'product/modalProduct.html',
		  targetEvent: event,
		  clickOutsideToClose:true,
	      locals : {
              resultModal : $scope,
              type : type
          }
	    })
	    .then(function() {
	    	$scope.selected = [];
		});
	  };
	  
//////Busca produtos de id
	$scope.getProductId = function (data) {
		ProductService.getProductId({data : data}, function (response) {
			if(response.data != undefined){
				$scope.listProducts = response.data;
			}else{
				toastr.warning("Produto não encontrado!");
			}
			$scope.isLoading = false;
		});

	};
	  
//////Busca todos os produtos do banco
	$scope.getProduct = function () {
		ProductService.getProduct(function (response) {
			$scope.items = response.data;
			$scope.isLoading = false;
		});

	};

////////////////////função de confirm pra deletar
	  $scope.showConfirm = function(ev) {
		  var confirm = $mdDialog.confirm()
		  .title('EXCLUIR ')
		  .textContent('Tem certeza que deseja excluir o(s) Produto(s)?')
		  .targetEvent(ev)
		  .ok('SIM')
		  .cancel('NÃO');
		  
		  $mdDialog.show(confirm).then(function() {
			  $scope.removeProduct();
		  }, function() {
		  });
	  };
	 
	   //////////função de deletar
	  $scope.removeProduct = function(){	
			var arrayId = []; 
			for (var i = 0; i < $scope.selected.length; i++) {
				arrayId.push($scope.selected[i].id);
			}
			var listId ={
					data: JSON.stringify(arrayId),
			};
				ProductService.removeProduct(listId, function(response){
				$scope.listProducts = response.data;
				$scope.selecionados = []; 
				toastr.success(response.message);
			});
		};
	
	//Chama função para buscar produtos
	$scope.getProduct();
	
	//Controller da modal
	function ModalController($scope, $mdDialog, resultModal, type) {
		listParent = [];
		
		if(type === "edit"){
			$scope.title = "Editar Produto";
			$scope.product = angular.copy(resultModal.selected[0]);
			$scope.showNewCategory = false;
						
		}else{
			$scope.title = "Adicionar Produto no ";
			$scope.showNewCategory = true;			
			
			if(resultModal.selected.length > 0){
				$scope.title += resultModal.selected[0].description;
				$scope.listParent = resultModal.selected[0];
				$scope.selectedProduct = true;
			}else{
				$scope.title = "Criar Nova Categoria";
				$scope.showNewCategory = false;
			}
		}

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
				resultModal.items = response.data;

			}),
				function (error) {
		
				};
		};

		$scope.selectParent = function (product) {
			$scope.listChildren = product.children;
		}

		$scope.selectChildren = function (product) {
			$scope.listParent = product.children;
		}

		

	  }

}]);