package br.com.desafio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	private String detail;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "parentId")
	private Product parentId;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parentId")
	@JsonIgnoreProperties(value = "parentId")
	private List<Product> children;
	
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Product getParentId() {
		return parentId;
	}

	public void setParentId(Product parentId) {
		this.parentId = parentId;
	}

	public List<Product> getChildren() {
		return children;
	}

	public void setChildren(List<Product> children) {
		this.children = children;
	}
	
}