package com.wissen.instantvendingmachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.instantvendingmachine.dto.ItemsTraysCombined;
import com.wissen.instantvendingmachine.entity.ItemsEntity;
import com.wissen.instantvendingmachine.entity.TraysEntity;
import com.wissen.instantvendingmachine.repository.ItemsRepository;
import com.wissen.instantvendingmachine.service.ItemsTraysCombinedService;
import com.wissen.instantvendingmachine.service.SelectItem;

@RestController
public class DisplayItemsController {
	@Autowired
	private ItemsRepository itemsRepository;
	@Autowired
	private ItemsTraysCombinedService itemsTraysCombinedService;
	@Autowired
	private SelectItem selectItem;

	@PostMapping("/decrement_quantity")
	public void decrementQuantity(@RequestParam long itemID) {
		TraysEntity trays = new TraysEntity();
		trays.setItemID(itemID);
		selectItem.decrementQuantity(itemID);
	}

	@GetMapping("/items")
	public ResponseEntity<List<ItemsEntity>> display() {
		List<ItemsEntity> items = itemsRepository.findAll();
		ResponseEntity<List<ItemsEntity>> entity = new ResponseEntity<>(items, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/dept/items/inner")
	public ResponseEntity<List<ItemsTraysCombined>> fetchItemsTraysDataInnerJoin() {
		return new ResponseEntity<>(itemsTraysCombinedService.fetchItemsTraysDataInnerJoin(), HttpStatus.OK);
	}

	@GetMapping("/compartment_name")
	public ResponseEntity<String> getComptName(long itemID) {

		return new ResponseEntity<>(selectItem.getCompartmentName(itemID), HttpStatus.OK);
	}
}
