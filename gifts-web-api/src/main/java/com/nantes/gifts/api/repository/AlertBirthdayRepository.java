package com.nantes.gifts.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nantes.gifts.api.bean.AlertBirthday;

public interface AlertBirthdayRepository extends JpaRepository<AlertBirthday, Long> {
	

}
