package br.com.desafio.jpa;

import java.util.List;

import br.com.desafio.bd.interfaces.ProductInterface;
import br.com.desafio.entity.Product;

public class ProductJPA  extends JPAAbstract<Product, Long> implements ProductInterface {

	public Product addUsuario(Product usu) {
		return this.add(usu);
	}

	public List<Product> findAll() {
		return this.list("SELECT P FROM "+ this.getEntityName() +" P where P.parentId is null");
	}
	
	public void removeUsuario(Long id){
		this.remove(id);
	}
	
	public List<Product>  findId(Long parentId) {
		return  this.list("SELECT P FROM "+ this.getEntityName() +" P WHERE P.parentId = '"+ parentId +"'" );
	}
	
	public Product editProduct(Product product) {
		return this.edit(product);
	}

}
