package com.markelov.onlineShop.repo;

import org.springframework.data.repository.CrudRepository;

import com.markelov.onlineShop.models.Objects;

public interface ObjectRepo extends CrudRepository<Objects, Long> {

}
