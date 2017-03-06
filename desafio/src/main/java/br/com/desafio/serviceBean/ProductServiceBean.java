package br.com.desafio.serviceBean;

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
import br.com.desafio.util.JPAUtil;

@Path("product")
public class ProductServiceBean {
	
	EntityManager manager = JPAUtil.getEntityManager();
	
	@GET
	@Path("/load")
	public Collection<ProductPojo> loadList(String description){
		String hql = "select new " + ProductPojo.class.getName() + "(id, code, description, note, subItem)  from " +
				Product.class.getSimpleName()  + " where id = subItem";
		
		Query query = manager.createQuery(hql);
		@SuppressWarnings("unchecked")
		Collection<ProductPojo> listProduct = query.getResultList();
		
		return listProduct;
	}
}
