package br.com.desafio.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.desafio.entity.ProductEntity;
import br.com.desafio.pojo.ProductPojo;
import br.com.desafio.service.ProductService;

@Path("/product")
public class ProductRest extends UtilRest {
	
	@GET
	@Path("/load/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response  loadList(@PathParam("id") int id) {
		try {
			
				List<ProductEntity> list = new ArrayList<ProductEntity>();
				ProductService productService = new ProductService(); 
				list = productService.loadList(id);
				return this.buildResponse(list);
				
		} catch (Exception e) {
			e.printStackTrace();	
			return this.buildErrorResponse(e.getMessage());
		}
	}
}


