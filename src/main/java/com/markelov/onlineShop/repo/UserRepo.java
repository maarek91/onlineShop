package com.markelov.onlineShop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markelov.onlineShop.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
