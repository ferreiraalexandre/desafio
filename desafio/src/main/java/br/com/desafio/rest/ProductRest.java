package br.com.desafio.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

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
			ProductService service = new ProductService(); 
			Product product = new Product();
			JSONObject jsonObject = new JSONObject(json);
					
			if(!jsonObject.isNull("categoriaPai")){
				
				String code = jsonObject.getString("code");
				String description = jsonObject.getString("description");
				//String note = null;
				String note = !jsonObject.isNull("note")  ? jsonObject.getString("note") : null;
				long id = Long.parseLong( (String) jsonObject.get("categoriaPai"));
				if(id > 0){
					product.setCategoriaPai(service.findId(id));
					product.setCode(code);
					product.setDescription(description);
					product.setNote(note);
				}
			}else {
				product = getObjectMapper().readValue(json, Product.class);
			}
		
			return getResponseAdd(service.addProduct(product));
		}catch(Exception e){
			return getResponseError(e);
		}
	}

	@GET
	@Path("/find")
	@Produces("application/json")
	public Response find() {
	
		try{
			ProductService service = new ProductService(); 
	
			List<Product> e = service.findAll();
	
			return getResponseList(e);
		} catch (Exception e) {
			return getResponseError(e);
		}
	}
}

