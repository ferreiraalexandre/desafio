package br.com.desafio.service;
import br.com.desafio.entity.Product;
import br.com.desafio.jpa.ProductJPA;

public class ProductService {

	public Object addProduct(Product product) {
		ProductJPA productJPA = new ProductJPA();
		productJPA.add(product);
		return product;
	}

//	public List<Usuario> listUsuario() throws Exception {
//		UsuarioJPA listUsuario = new UsuarioJPA();
//		return listUsuario.list();
//	}

	
}
