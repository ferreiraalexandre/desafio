package br.com.desafio.bd.interfaces;

import java.util.List;

import br.com.desafio.object.Product;

public interface ProductDAO extends CrudDAO<Product,Integer>{
	
	public List<Product> getListProduct();
}
