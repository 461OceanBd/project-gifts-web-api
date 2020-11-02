package com.nantes.gifts.api.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String completeName;
	private String nickName;
	private Date birthDate;
	private boolean isActive;
	private String picture;
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private AlertBirthday alertBirthday;
	
	@ManyToOne
	private User user;
	
	
	
	public Person(long id, String completeName, String nickName, Date birthDate, boolean isActive, String picture) {
		super();
		this.id = id;
		this.completeName = completeName;
		this.nickName = nickName;
		this.birthDate = birthDate;
		this.isActive = isActive;
		this.picture = picture;
		
	}

	public Person() {
		super();
		
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	

}
