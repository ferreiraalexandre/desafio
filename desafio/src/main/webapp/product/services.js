
app.factory('ProductService',['$resource',  function ($resource) {
	  return $resource(app.pathRest + '/pruduct/:method/:id', {}, {
		  postUsuario: { method: 'POST', params: {method: 'salve'}}, 
		   
	  })
	}]);
