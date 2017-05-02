package br.com.desafio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 80, nullable = false)
	private String code;
	
	@Column(length = 80, nullable = false)
	private String description;
	
	@Column(length = 80, nullable = true)
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "categoria_pai")
	private Product categoriaPai;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoriaPai")
	@JsonIgnoreProperties(value = "categoriaPai")
	private List<Product> subcategorias;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Product getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Product categoriaPai) {
		this.categoriaPai = categoriaPai;
	}
	
	public List<Product> getSubcategorias() {
		return subcategorias;
	}
	
	public void setSubcategorias(List<Product> subcategorias) {
		this.subcategorias = subcategorias;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}