package com.nantes.gifts.api.bean;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.nantes.gifts.api.bean.enums.Delay;
import com.nantes.gifts.api.bean.enums.Frequency;

@Entity
public class AlertBirthday {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private boolean isActive;
	private LocalTime hourAlert;
	@Enumerated(EnumType.STRING)
	private Frequency frequency;
	@Enumerated(EnumType.STRING)
	private Delay delay;
	

}
