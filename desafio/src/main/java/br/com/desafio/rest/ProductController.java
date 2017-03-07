package br.com.desafio.rest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

import br.com.desafio.entity.Product;
import br.com.desafio.pojo.ProductPojo;
import br.com.desafio.util.JPAUtil;

@Path("/product")
public class ProductController {
	
	EntityManager manager = JPAUtil.getEntityManager();
	
	@GET
	@Path("/load")
	public Collection<ProductPojo> loadList(String description){
		String hql = "select new " + ProductPojo.class.getName() + "(id, code, description, note, owner_id)  from " +
				Product.class.getSimpleName() ;
		Query query = manager.createQuery(hql);
		@SuppressWarnings("unchecked")
		Collection<ProductPojo> listProduct = query.getResultList();
		
		return listProduct;
	}
}
