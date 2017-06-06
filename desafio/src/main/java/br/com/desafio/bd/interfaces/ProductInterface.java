package br.com.desafio.bd.interfaces;

import java.util.List;

import br.com.desafio.entity.Product;

public interface ProductInterface{
	
	public Product addUsuario(Product usu);
	public List<Product> findAll();
	public void removeUsuario(long id);
	public List<Product> findId(Long id);
	
}
