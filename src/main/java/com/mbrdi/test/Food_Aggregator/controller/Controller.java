package com.mbrdi.test.Food_Aggregator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mbrdi.test.Food_Aggregator.service.AggregateService;
import com.mbrdi.test.Food_Aggregator.supplier.Food;

@RestController
public class Controller {

	@Autowired
	AggregateService service;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/buy-item/{name}")
	public List<Food> buyItem(@PathVariable String name) {
		return  service.buyItem(name);
		}
	
	@GetMapping("/buy-item-qty/{name}/{quantity}")
	public List<Food> buyItemQty(@PathVariable String name, @PathVariable int quantity) {
		return service.buyItemQty(name,quantity);
	}

}
