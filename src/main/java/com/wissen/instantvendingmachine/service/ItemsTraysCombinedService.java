package com.wissen.instantvendingmachine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.instantvendingmachine.dto.ItemsTraysCombined;
import com.wissen.instantvendingmachine.entity.ItemsEntity;
import com.wissen.instantvendingmachine.repository.ItemsRepository;

@Service
public class ItemsTraysCombinedService {
	@Autowired
	private ItemsRepository itemsRepository;

	public List<ItemsTraysCombined> fetchItemsTraysDataInnerJoin() {

		List<ItemsTraysCombined> list = new ArrayList<>();

		List<ItemsEntity> items = itemsRepository.findAll();

		for (ItemsEntity itemsEntity : items) {

			long itemID = itemsEntity.getItemID();
			String itemName = itemsEntity.getItemName();
			String itemCategory = itemsEntity.getItemCategory();
			float itemPrice = itemsEntity.getItemPrice();

			int quantity = itemsEntity.getTraysEntity().getQuantity();

			ItemsTraysCombined itemsTraysCombined = new ItemsTraysCombined(itemID, itemName, itemPrice, itemCategory,
					quantity);

			list.add(itemsTraysCombined);

		}

		return list;
	}

}
