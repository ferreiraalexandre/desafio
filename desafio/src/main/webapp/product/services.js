
app.factory('ProductService',['$resource',  function ($resource) {
	  return $resource(app.pathRest + '/product/:method/:id', {}, {
		  postProduct: { method: 'POST', params: {method: 'save'}}, 
		  getProduct:  { method: 'GET', params: {method: 'find'}, isArray: false }
		   
	  })
	}]);
