package br.com.desafio.service;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.bd.interfaces.ProductDAO;
import br.com.desafio.object.Product;

public class ProductService  extends ServiceAbstract<Product, Integer, ProductDAO>{

	public List<Product> getListProduct(){
		List<Product> listProduct = this.dao.getListProduct();
		
		
		List<Product> sub =  new ArrayList<Product>();
		
		for (Product c : listProduct) {
			c.setDescricao("teste");
			sub.add(c);
			
		}
		
		
//		for(Product lp : listProduct){
//			if(lp.getOwner() != null){
//			//	lp.setDescription(lp.getDescription());//pai
//				pai.add(lp);
//			}
//			
//		}
		return sub;
	}
}
