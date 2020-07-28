package com.markelov.onlineShop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.markelov.onlineShop.models.Bag;
import com.markelov.onlineShop.models.Order;
import com.markelov.onlineShop.repo.BagRepo;
import com.markelov.onlineShop.repo.OrderRepo;

@Controller
public class OrderController {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private BagRepo bagRepo;
	
	@PostMapping("/order")
	public String order(Model model) {
			Iterable<Bag> bag = bagRepo.findAll();
			Long id;
			for (Bag x: bag) {
				Order order = new Order(x.getTitle(), x.getPrice());
				orderRepo.save(order);
				id = order.getId();
			}
			bagRepo.deleteAll();
			return "order";
	}
	
	@GetMapping("/orderbag")
	public String orderBag(Model model) {
			Iterable<Order> order = orderRepo.findAll();
			model.addAttribute("order", order);
			return "orderBag";
	}
}
