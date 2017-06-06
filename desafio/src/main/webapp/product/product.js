///  Documentação http://embed.plnkr.co/bKJNoG/
app.controller('DesafioController', ['$scope','ProductService', '$mdDialog','$timeout', 'toastr',
                             function($scope,  ProductService,   $mdDialog,  $timeout,   toastr) {
	$scope.selected = [];
	$scope.isLoading = true;
	
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
	}
	
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
	    })
	    .then(function() {
	    	$scope.selected = [];
		});
	  };
	  
//////Busca produtos de id
	$scope.getProductId = function (data) {
		var id = 1;
		ProductService.getProductId({id : id}, function (response) {
			$scope.listProducts = response.data;
			$scope.isLoading = false;
		});

	};
	  
//////Busca todos os produtos do banco
	$scope.getProduct = function () {
		ProductService.getProduct(function (response) {
			$scope.listProducts = response.data;
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
	function ModalController($scope, $mdDialog, resultModal) {
		listParent = [];
		
		if(resultModal.selected.length==1){
			$scope.title = "Editar Produto";
			$scope.product = resultModal.selected[0];	
		}else{
			$scope.title = "Adicionar Produto";
			$scope.product = resultModal.selected[0];
		
			if(resultModal.listProducts != undefined){
				resultModal.listProducts.push({"description": "Nova Categoria"});				
				$scope.listParent = resultModal.listProducts
			}else{
				listParent.push({"description": "Nova Categoria"});
				$scope.listParent = listParent;
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
			if(data.parentId.description == "Nova Categoria"){
				data.parentId = null;
			}
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