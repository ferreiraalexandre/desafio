package br.com.desafio.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.desafio.entity.Product;
import br.com.desafio.pojo.ProductPojo;
import br.com.desafio.service.ProductService;
import br.com.desafio.util.JPAUtil;

@Path("product")
public class ProductRest {
	
	EntityManager manager = JPAUtil.getEntityManager();
	

	/* Método que carrega todos os lançamentos, na tela de Lançamentos. */
	
	@GET
	@Path("/load/{description}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response loadList(@PathParam("description") String description) {
		try {
			List<ProductPojo> listProduct= new ArrayList<ProductPojo>();
			ProductService service= new ProductService();
			
			listProduct =service.loadList(description);
            
			return this.buildResponse(listProduct);
			
		} catch (Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}	
}
