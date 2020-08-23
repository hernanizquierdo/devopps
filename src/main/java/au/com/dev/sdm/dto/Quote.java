package au.com.dev.sdm.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import au.com.dev.service.Constants;

@Entity
public class Quote implements Serializable{

	private static final long serialVersionUID = -7469729110371016928L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private Long id;
	
	@Column(nullable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.yyyyMMddHHmm , timezone = Constants.TIME_ZONE)
	@CreationTimestamp
	private Date created;
	
	@OneToMany(targetEntity = QuoteResource.class, mappedBy = "quote", cascade = CascadeType.MERGE)
	private List<QuoteResource> quoteResources;
	
	@ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable= false)
	private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<QuoteResource> getQuoteResources() {
		return quoteResources;
	}

	public void setQuoteResources(List<QuoteResource> quoteResources) {
		this.quoteResources = quoteResources;
	} 

}
