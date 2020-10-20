package com.nantes.gifts.api.bean;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.nantes.gifts.api.bean.enums.Delay;
import com.nantes.gifts.api.bean.enums.Frequency;

@Entity
public class AlertBirthday {
	
	/*
	 * Dans cette classe on a un id qui n'est pas généré car l'id de AlertBirthday est mappé sur celui de Person pour avoir
	 * les mêmes id (via le @MapsId)
	 * 
	 * */
	
	@Id
	private long id;
	private boolean isActive;
	private LocalTime hourAlert;
	@Enumerated(EnumType.STRING)
	private Frequency frequency;
	@Enumerated(EnumType.STRING)
	private Delay delay;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Person person;
	
	
	public AlertBirthday(long id, boolean isActive, LocalTime hourAlert, Frequency frequency, Delay delay) {
		super();
		this.id = id;
		this.isActive = isActive = false;
		this.hourAlert = hourAlert;
		this.frequency = frequency;
		this.delay = delay;
	}
	
	public AlertBirthday(Person person) {
		super();
		this.person = person;
		this.isActive = false;
	}
	
	
	public AlertBirthday() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public LocalTime getHourAlert() {
		return hourAlert;
	}
	public void setHourAlert(LocalTime hourAlert) {
		this.hourAlert = hourAlert;
	}
	public Frequency getFrequency() {
		return frequency;
	}
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}
	public Delay getDelay() {
		return delay;
	}
	public void setDelay(Delay delay) {
		this.delay = delay;
	}
	
	
	
	

}
