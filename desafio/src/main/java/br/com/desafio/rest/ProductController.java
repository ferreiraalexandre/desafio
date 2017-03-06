package br.com.desafio.rest;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import br.com.desafio.entity.Product;
import br.com.desafio.pojo.ProductPojo;
import br.com.desafio.util.JPAUtil;

@Path("/product")
public class ProductController {
	
	EntityManager manager = JPAUtil.getEntityManager();
	

	/* Método que carrega todos os lançamentos, na tela de Lançamentos. */
	@GET
	@Path("/load")
	public Collection<ProductPojo> loadList(@Context HttpServletRequest request){
		String hql = "select new " + ProductPojo.class.getName() + "(id, code, description, note, subItem)  from " +
				Product.class.getSimpleName()  + " where id = subItem";
		
		Query query = manager.createQuery(hql);
		@SuppressWarnings("unchecked")
		Collection<ProductPojo> listProduct = query.getResultList();
		
		return listProduct;
	}
}
