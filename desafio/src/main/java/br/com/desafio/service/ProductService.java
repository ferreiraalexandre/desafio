package br.com.desafio.service;
import java.util.List;

import br.com.desafio.entity.Product;
import br.com.desafio.jpa.ProductJPA;

public class ProductService {

	public Object addProduct(Product product) {
		ProductJPA productJPA = new ProductJPA();
		productJPA.add(product);
		return product;
	}

	public List<Product> findAll() throws Exception {
		ProductJPA listProduct = new ProductJPA();
	
		return listProduct.findAll();
	}

	public Product findId(Long id) throws Exception {
		ProductJPA listProduct = new ProductJPA();
	
		return listProduct.findId(id);
	}

}
