package au.com.dev.sdm.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuoteResource implements Serializable{

	private static final long serialVersionUID = 9103982191332341551L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private Long id;
	
	@ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "resource_id", referencedColumnName = "id", nullable= false)
	private Resource resource;
	
	@ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "quote_id", referencedColumnName = "id", nullable= false)
	private Quote quote;
	
	@Column(nullable = false, length = 5, columnDefinition = "integer default 0")
	private Integer qty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
