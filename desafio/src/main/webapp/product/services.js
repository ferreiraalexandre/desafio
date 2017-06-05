
app.factory('ProductService',['$resource',  function ($resource) {
	  return $resource(app.pathRest + '/product/:method/:data', {}, {
		  postProduct: { method: 'POST', params: {method: 'save'}}, 
		  getProduct:  { method: 'GET', params: {method: 'find'}, isArray: false },
		  removeProduct: { method: 'DELETE', params: {method: 'remove'}, isArray: false, interceptor: {responseError : resultError}}

	  })
}]);

function resultError(response) {
	alert(response.data.message + "\n" + response.data.description);
};
