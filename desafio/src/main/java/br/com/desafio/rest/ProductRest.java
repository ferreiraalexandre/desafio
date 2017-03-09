package br.com.desafio.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.desafio.object.Product;
import br.com.desafio.service.ProductService;
import br.com.desafio.rest.abs.RestAbstract;

@Path("/product")
public class ProductRest extends RestAbstract<Product,Integer,ProductService>{
	
	@GET
	@Path("/listProduct")
	@Produces("application/json")
	public Response getListProduct(){
		try{
			ProductService service = this.service.newInstance();
			
			return getResponseList(service.getListProduct());
		}catch(Exception e){
			return getResponseError(e);
		}
	}
}


