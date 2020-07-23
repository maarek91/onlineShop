package com.markelov.onlineShop.repo;

import org.springframework.data.repository.CrudRepository;

import com.markelov.onlineShop.models.Order;

public interface OrderRepo extends CrudRepository <Order, Long> {
	
}
