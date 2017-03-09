package br.com.desafio.service;

import java.util.List;

import br.com.desafio.bd.interfaces.ProductDAO;
import br.com.desafio.object.Product;

public class ProductService  extends ServiceAbstract<Product, Integer, ProductDAO>{

	public List<Product> getListProduct(){
		return this.dao.getListProduct();
	}
}
