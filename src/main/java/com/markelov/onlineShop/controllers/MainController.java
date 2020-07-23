package com.markelov.onlineShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.markelov.onlineShop.models.Objects;
import com.markelov.onlineShop.repo.ObjectRepo;


@Controller
public class MainController {

	@Autowired
	private ObjectRepo objectRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		Iterable<Objects> objects = objectRepo.findAll();
		model.addAttribute("objects", objects);
		return "home";
	}
	
	@GetMapping("/testcase")
	public String testcase(Model model) {
		model.addAttribute("title", "Тестовое задание");
		return "testcase";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("title", "Войти");
		return "testcase";
	}
	

}
