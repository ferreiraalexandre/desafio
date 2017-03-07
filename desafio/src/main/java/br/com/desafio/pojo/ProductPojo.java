package br.com.desafio.pojo;

public class ProductPojo {

	private Long id;	
	private String code;
	private String description;
	private String note;
	private Long owner;

	public ProductPojo(String description) {
		this.description = description;
	}

	public ProductPojo(Long id, String code, String description, String note, Long owner) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.note = note;
		this.owner = owner;
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

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}
	
}