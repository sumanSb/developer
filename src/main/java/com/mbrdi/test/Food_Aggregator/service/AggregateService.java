package com.mbrdi.test.Food_Aggregator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mbrdi.test.Food_Aggregator.exception.NotFoundException;
import com.mbrdi.test.Food_Aggregator.supplier.Food;

@Service
public class AggregateService {

	@Value("${fruit.supplier}")
	private String fruitSupplier;

	@Value("${vegetable.supplier}")
	private String vegetableSupplier;

	@Value("${grain.supplier}")
	private String grainSupplier;

	@Autowired
	RestTemplate restTemplate;

	public List<Food> buyItem(String name) {
		List<Food> listFood = new ArrayList<>();
		ResponseEntity<List<Food>> response;
		response = restTemplate.exchange(fruitSupplier, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Food>>() {
				});
		listFood.addAll(response.getBody());

		response = restTemplate.exchange(vegetableSupplier, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Food>>() {
				});
		listFood.addAll(response.getBody());

		response = restTemplate.exchange(grainSupplier, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Food>>() {
				});

		listFood.addAll(response.getBody());
		List<Food> list = new ArrayList<>();
		for (Food f : listFood) {
			if (f.getName().equals(name))
				list.add(f);
		}
		if (list.size() > 0) {
			return list;
		}
	    throw new NotFoundException("Item not available");
	}

	public List<Food> buyItemQty(String name, int quantity) {
		List<Food> listFood = new ArrayList<>();
		ResponseEntity<List<Food>> response;
		response = restTemplate.exchange(fruitSupplier, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Food>>() {
				});
		listFood.addAll(response.getBody());

		response = restTemplate.exchange(vegetableSupplier, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Food>>() {
				});
		listFood.addAll(response.getBody());

		response = restTemplate.exchange(grainSupplier, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Food>>() {
				});

		listFood.addAll(response.getBody());
		List<Food> list = new ArrayList<>();
		for (Food f : listFood) {
			if (f.getName().equals(name) && f.getQuantity() >= quantity)
				list.add(f);
		}
		if (list.size() > 0) {
			return list;
		}
		throw new NotFoundException("Item not available");
	}

}
