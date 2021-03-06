package br.com.desafio.service;
import java.util.List;

import org.json.JSONArray;

import br.com.desafio.entity.Product;
import br.com.desafio.jpa.ProductJPA;

public class ProductService {

	public Object addProduct(Product product) {
		ProductJPA productJPA = new ProductJPA();
		productJPA.add(product);
		return productJPA.findAll();
	}

	public List<Product> findAll() throws Exception {
		ProductJPA listProduct = new ProductJPA();
	
		return listProduct.findAll();
	}
	
	public Object removeProduct(JSONArray listId) throws Exception{
		ProductJPA prodJPA = new ProductJPA();
			
		if(listId != null && listId.length() > 0){
			for (int i = 0; i < listId.length(); i++) {
				prodJPA.removeUsuario(listId.getLong(i));
			}
		}
		return prodJPA.findAll();
	}
	
	public List<Product> findAllById(Long parentId) throws Exception {
		ProductJPA listProduct = new ProductJPA();
	
		return listProduct.findId(parentId);
	}
	
	public Object editProduct(Product product) {
		ProductJPA prod = new ProductJPA();
		prod.editProduct(product);
		return prod.list();
	}


}
