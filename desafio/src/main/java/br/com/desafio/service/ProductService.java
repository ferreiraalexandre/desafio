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
				Product product = prodJPA.findId(listId.getLong(i));
				if(product.getChildren() != null){
					for (Product children : product.getChildren()) {
						prodJPA.removeUsuario(children.getId());
					}
				}else{
					prodJPA.removeUsuario(listId.getLong(i));					
				}
			}
		}
		return prodJPA.findAll();
	}
}
