package br.com.desafio.bb.jpa;

import java.util.List;

import br.com.desafio.bd.interfaces.ProductDAO;
import br.com.desafio.object.Product;

public class ProductJPADAO  extends JPAAbstract<Product,Integer> implements ProductDAO{
	
	public List<Product> getListProduct() {
		
		return this.list("SELECT E FROM " + this.getEntityName() + " E");
	}
}

