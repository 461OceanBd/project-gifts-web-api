package com.nantes.gifts.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nantes.gifts.api.bean.Gift;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {

}
