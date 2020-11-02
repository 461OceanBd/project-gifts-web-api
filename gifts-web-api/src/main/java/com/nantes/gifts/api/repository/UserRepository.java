package com.nantes.gifts.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nantes.gifts.api.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
