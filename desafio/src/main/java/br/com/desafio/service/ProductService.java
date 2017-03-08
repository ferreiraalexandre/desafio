package br.com.desafio.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.desafio.dao.ProductDaoImpl;
import br.com.desafio.entity.ProductEntity;
import br.com.desafio.exception.ProductException;
import br.com.desafio.pojo.ProductPojo;

public class ProductService {

	public List<ProductEntity> loadList(int id) throws ProductException {
		ProductPojo list = new ProductPojo();
		List<ProductEntity> result = new ArrayList<>();
		try {

			ProductDaoImpl productDaoImpl = new ProductDaoImpl();
			Collection<ProductEntity> c = productDaoImpl.loadList(id);
			result.addAll(c);
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
		return result;
	}
}
