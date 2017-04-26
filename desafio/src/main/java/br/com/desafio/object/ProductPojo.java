package br.com.desafio.object;

import java.util.List;

public class ProductPojo {

	private Long id;
	private String descricao;
	private List<ProductPojo> subcategorias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProductPojo> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<ProductPojo> subcategorias) {
		this.subcategorias = subcategorias;
	}


	

}