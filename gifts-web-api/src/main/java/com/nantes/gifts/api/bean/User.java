package com.nantes.gifts.api.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String pseudo;
	private String password;
	private String email;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Person> persons;



	public User(long id, String pseudo, String password, String email, List<Person> persons) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		this.email = email;
		this.persons = persons;
	}

	
	public User() {
		super();
	}

	
	public User(long id, String pseudo, String password, String email) {
	super();
	this.id = id;
	this.pseudo = pseudo;
	this.password = password;
	this.email = email;
}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	
	
	
	
	
	
	
	
	
	

}
