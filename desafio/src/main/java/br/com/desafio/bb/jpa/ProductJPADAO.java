package br.com.desafio.bb.jpa;

import java.util.List;

import br.com.desafio.bd.interfaces.ProductDAO;
import br.com.desafio.object.Product;

public class ProductJPADAO  extends JPAAbstract<Product,Integer> implements ProductDAO{
	
	public List<Product> getListProduct() {
		
		return this.list("SELECT t1.id,t1.description,t1.note,t1.owner_id E FROM " + this.getEntityName() + " E  AS t1 LEFT JOIN product t2 ON t1.id = t2.owner_id WHERE t2.owner_id IS NULL");
	}
}

//SELECT t1.id,t1.description,t1.note,t1.owner_id FROM
//product AS t1 LEFT JOIN product t2
//ON t1.id = t2.owner_id
//WHERE t2.owner_id IS NULL;

//SELECT t1.id,t1.description,t1.note,t1.owner_id FROM
//product AS t1 LEFT JOIN product t2
//ON t1.id = t2.owner_id
//WHERE t2.owner_id IS NULL;
//
//SELECT t1.description AS lev1, t2.description as lev2, t3.description as lev3, t4.description as lev4
//FROM product AS t1
//LEFT JOIN product AS t2 ON t2.owner_id = t1.id
//LEFT JOIN product AS t3 ON t3.owner_id = t2.id
//LEFT JOIN product AS t4 ON t4.owner_id = t3.id
//WHERE t1.description = 'masculino';