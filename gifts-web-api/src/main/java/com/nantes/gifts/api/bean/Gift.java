package com.nantes.gifts.api.bean;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gifts")
public class Gift {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date creationDate;
	private boolean isActive;
	
	//self join annotation, reflexive association for a parent gift
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parentGift_id", nullable = true)
	private Gift parentGift;
	
//	@OneToMany(mappedBy = "parentGift")
//	private Set<Gift> gifts = new HashSet<Gift>();
	
	

	public Gift() {
		super();
		this.creationDate = new Date();
		this.isActive = true;
	}
	
	

	public Gift(long id, Date creationDate, boolean isActive, Gift parentGift) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.isActive = isActive;
		this.parentGift = parentGift;
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public Gift getParentGift() {
		return parentGift;
	}


	public void setParentGift(Gift parentGift) {
		this.parentGift = parentGift;
	}
	
	
	
	
	
	
	
	
	

}
