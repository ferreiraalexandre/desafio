package br.com.desafio.bb.jpa;

import br.com.desafio.bd.interfaces.ProductDAO;

public class DAOFactory {

	@SuppressWarnings("rawtypes")
	public static Object getInstanceOf(Class c){
		
		if(c.equals(ProductDAO.class)){
			return new ProductJPADAO();
		}else{
			return null;
		}
	}
}
