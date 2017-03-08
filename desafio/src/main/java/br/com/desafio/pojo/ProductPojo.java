package br.com.desafio.pojo;

import br.com.desafio.entity.ProductEntity;

public class ProductPojo {

	private Long id;	
	private String code;
	private String description;
	private String note;
	private ProductEntity owner;

	
	public ProductPojo() {
		super();
	}
	
	public ProductPojo(Long id, String code, String description, String note, ProductEntity owner) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.note = note;
		this.owner = owner;
	}
	
	public ProductPojo(Long id, String code, String description, String note) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.note = note;
	}

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

	public ProductEntity getOwner() {
		return owner;
	}

	public void setOwner(ProductEntity owner) {
		this.owner = owner;
	}
	
}