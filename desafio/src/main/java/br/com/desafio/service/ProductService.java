package br.com.desafio.service;

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
import br.com.desafio.exception.ProductException;
import br.com.desafio.pojo.ProductPojo;
import br.com.desafio.serviceBean.ProductServiceBean;
import br.com.desafio.util.JPAUtil;


public class ProductService {
	
	public ProductPojo loadList(String description) throws ProductException {
		Collection<ProductPojo> listProduct = Collection ;
		
		try {
			ProductServiceBean load = new ProductServiceBean();
			listProduct = load.loadList(description);

		} catch (ProductException e) {
			throw e;
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		} 		
		return listProduct; 
	}


}
