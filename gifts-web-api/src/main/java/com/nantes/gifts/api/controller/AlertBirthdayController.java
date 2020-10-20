package com.nantes.gifts.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nantes.gifts.api.bean.AlertBirthday;
import com.nantes.gifts.api.exception.RessourceNotFoundException;
import com.nantes.gifts.api.repository.AlertBirthdayRepository;

@RestController
@RequestMapping("/api/")
public class AlertBirthdayController {
	
	
	@Autowired
	AlertBirthdayRepository alertBirthdayRepository;
	
	
	//Get all alertBirthday
	@GetMapping("alertBirthday")
	public List<AlertBirthday> getAllAlertBirthday(){
		return this.alertBirthdayRepository.findAll();
	}
	
	//Get alert birthday by id
	@GetMapping("alertBirthday/{id}")
	public  ResponseEntity<AlertBirthday> getAlertBirthdayById(@PathVariable(value = "id") Long alerBirthdayId){
		
		Optional<AlertBirthday> optAlertBirthday = alertBirthdayRepository.findById(alerBirthdayId);
		if(optAlertBirthday.isPresent()) {
			AlertBirthday alertBirthday = optAlertBirthday.get();
			return ResponseEntity.ok().body(alertBirthday);
		} else {
			throw new RessourceNotFoundException("Alert Birthday not found for this id :: " + alerBirthdayId); //return a 404
		}
		
	}
	
	
	//Update AlertBirthday
	@PutMapping("alertBirthday/{id}")
	public ResponseEntity<AlertBirthday> updateAlertBirthday(@PathVariable(value = "id") Long alertBirthdayId,
			@Validated @RequestBody AlertBirthday alertBirthdayDetails) throws RessourceNotFoundException {
		
		AlertBirthday alertBirthday = alertBirthdayRepository.findById(alertBirthdayId)
				.orElseThrow(() -> new RessourceNotFoundException("Alert Birthday not found for this id:: " + alertBirthdayId));
		
		alertBirthday.setActive(alertBirthdayDetails.isActive());
		alertBirthday.setHourAlert(alertBirthdayDetails.getHourAlert());
		alertBirthday.setFrequency(alertBirthdayDetails.getFrequency());
		alertBirthday.setDelay(alertBirthdayDetails.getDelay());
		
		return ResponseEntity.ok(this.alertBirthdayRepository.save(alertBirthday));
		
	}

}
