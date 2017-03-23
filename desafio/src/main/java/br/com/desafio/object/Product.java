package br.com.desafio.object;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private Product categoriaPai;
	private List<Product> subcategorias;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 80, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne
	@JoinColumn(name = "categoria_pai")
	public Product getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Product categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	@OneToMany(mappedBy = "categoriaPai")
	public List<Product> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<Product> subcategorias) {
		this.subcategorias = subcategorias;
	}

}