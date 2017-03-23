package br.com.desafio.bb.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.desafio.bd.interfaces.ProductDAO;
import br.com.desafio.object.Product;
import br.com.desafio.util.JPAUtil;


public class ProductJPADAO  extends JPAAbstract<Product,Integer> implements ProductDAO{
	EntityManager manager = JPAUtil.getEntityManager();
	
	public List<Product> getListProduct() {
		return manager.createQuery("from Product where categoriaPai is null", Product.class).getResultList();
		
		
//				return this.list("SELECT E FROM " +  Product.class.getSimpleName() + " E "
//				+ " E LEFT JOIN " +  Product.class.getSimpleName()
//				+ " P ON E.id = P.owner_id"
//				+ "  WHERE categoriaPai IS NULL");
		
}
	}

//SELECT p1.id,p1.description,p1.code,p1.note,p1.owner_id FROM
//product AS p1 LEFT JOIN product AS p2
//ON p1.id = p2.owner_id
//WHERE p2.owner_id IS NULL;

//select n from Node n where parent is null