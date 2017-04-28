package br.com.desafio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
	
	}