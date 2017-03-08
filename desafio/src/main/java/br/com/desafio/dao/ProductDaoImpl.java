package br.com.desafio.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

import br.com.desafio.entity.ProductEntity;
import br.com.desafio.pojo.ProductPojo;
import br.com.desafio.util.JPAUtil;

@Path("/product")
public class ProductDaoImpl  implements ProductDao {
	
	EntityManager manager = JPAUtil.getEntityManager();
	
	@GET
	@Path("/load")
	public Collection<ProductEntity> loadList(int id){
		String hql = "select o from Product o";
		Query query = manager.createQuery(hql);
		@SuppressWarnings("unchecked")
		Collection<ProductEntity> listProduct = query.getResultList();
		
		return listProduct;
	}
}
