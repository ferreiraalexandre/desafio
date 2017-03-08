package br.com.desafio.dao;

import java.util.Collection;

import br.com.desafio.entity.ProductEntity;

public interface ProductDao {
	
	public Collection<ProductEntity> loadList(int id);
}
