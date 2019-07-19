package com.wissen.instantvendingmachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.instantvendingmachine.entity.ItemsEntity;
import com.wissen.instantvendingmachine.repository.ItemsRepository;

@RestController
public class DisplayItemsController {

	@Autowired
	private ItemsRepository itemsRepository;

	@GetMapping("/items")
	public List<ItemsEntity> display() {
		List<ItemsEntity> items = itemsRepository.findAll();
		return items;
	}

}
