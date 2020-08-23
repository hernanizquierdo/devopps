package au.com.dev.sdm.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Resource implements Serializable{

	private static final long serialVersionUID = 1085374336299587536L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private Long id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 5)
	private Double price;
	
	@OneToMany(targetEntity = QuoteResource.class, mappedBy = "resource", cascade = CascadeType.MERGE)
	private List<QuoteResource> quoteResources;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
