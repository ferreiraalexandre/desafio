package br.com.desafio.jpa;

import br.com.desafio.bd.interfaces.ProductInterface;
import br.com.desafio.entity.Product;

public class ProductJPA  extends JPAAbstract<Product, Long> implements ProductInterface {

	public Product addUsuario(Product usu) {
		return this.add(usu);
	}
}
//	public List<Usuario> list(){
//		return this.list("");
//	}
//
//}


//package br.com.desafio.bb.jpa;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import br.com.desafio.bd.interfaces.ProductDAO;
//import br.com.desafio.entity.Product;
//import br.com.desafio.restUtil.JPAUtil;
//
//
//public class ProductJPA  extends JPAAbstract<Product,Integer> implements ProductDAO{
//
//	
//	public List<Product> getListProduct() {
//		return manager.createQuery("from Product where categoriaPai is null", Product.class).getResultList();
//		
//		
//				return this.list("SELECT E FROM " +  Product.class.getSimpleName() + " E "
//				+ " E LEFT JOIN " +  Product.class.getSimpleName()
//				+ " P ON E.id = P.owner_id"
//				+ "  WHERE categoriaPai IS NULL");
//		
//}
//	}
//
//SELECT p1.id,p1.description,p1.code,p1.note,p1.owner_id FROM
//product AS p1 LEFT JOIN product AS p2
//ON p1.id = p2.owner_id
//WHERE p2.owner_id IS NULL;
//
//select n from Node n where parent is null