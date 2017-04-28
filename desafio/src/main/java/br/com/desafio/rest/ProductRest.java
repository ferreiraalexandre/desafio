package br.com.desafio.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.desafio.entity.Product;
import br.com.desafio.restUtil.UtilRest;
import br.com.desafio.service.ProductService;

@Path("/product")
public class ProductRest extends UtilRest{
	
	@POST
	@Path("/save")
	@Consumes("application/json")
	@Produces("application/json")
	public Response save( String json){

		
		try{
			Product product = getObjectMapper().readValue(json, Product.class);
		
			product.setCategoriaPai(product);
			ProductService service = new ProductService(); 
					
			return getResponseAdd(service.addProduct(product));
		}catch(Exception e){
			return getResponseError(e);
		}
	}
}
//	@GET
//	@Path("/listProduct")
//	@Produces("application/json")
//	public Response getListProduct(){
//		try{
//			ProductService service = this.service.newInstance();
//			
//			return getResponseList(service.getListProduct());
//		}catch(Exception e){
//			return getResponseError(e);
//		}
//	}
//}


