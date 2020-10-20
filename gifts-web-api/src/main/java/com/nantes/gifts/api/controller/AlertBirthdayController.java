package com.nantes.gifts.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nantes.gifts.api.bean.AlertBirthday;
import com.nantes.gifts.api.repository.AlertBirthdayRepository;

@RestController
@RequestMapping("/api/")
public class AlertBirthdayController {
	
	
	@Autowired
	AlertBirthdayRepository alertBirthdayRepository;
	
	
	//Get all persons
	@GetMapping("alertBirthday")
	public List<AlertBirthday> getAllAlertBirthday(){
		return this.alertBirthdayRepository.findAll();
	}
	
	
	
	

}
