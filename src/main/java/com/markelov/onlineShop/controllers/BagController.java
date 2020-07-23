package com.markelov.onlineShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.markelov.onlineShop.models.Bag;
import com.markelov.onlineShop.repo.BagRepo;

@Controller
public class BagController {
	
	@Autowired
	private BagRepo bagRepo;
	
	@GetMapping("/bag")
	public String bagMain(Model model) {
		Iterable<Bag> bag = bagRepo.findAll();
		model.addAttribute("bag", bag);
		return "bag";
	}
	
	@PostMapping("/bag")
	public String bagAdd(@RequestParam String title,
			@RequestParam String price,
			Model model) {
			Bag bag = new Bag(title, price);
			bagRepo.save(bag);
		return "redirect:/";
	}
	
	@PostMapping("/bag/{id}/remove")
	public String bagDelete(@PathVariable(value = "id") long id,
			Model model) {	
		Bag bag = bagRepo.findById(id).orElseThrow(IllegalStateException::new);
		bagRepo.delete(bag);
		return "redirect:/bag";
	}
}
