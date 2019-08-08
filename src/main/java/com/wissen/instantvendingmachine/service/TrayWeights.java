package com.wissen.instantvendingmachine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.instantvendingmachine.dto.ItemsBoughtInfoDto;
import com.wissen.instantvendingmachine.dto.UpdatingTrayWeightsDto;
import com.wissen.instantvendingmachine.entity.OrderItemsEntity;
import com.wissen.instantvendingmachine.entity.TrayComptEntity;
import com.wissen.instantvendingmachine.entity.TraysEntity;
import com.wissen.instantvendingmachine.repository.ItemsRepository;
import com.wissen.instantvendingmachine.repository.OrderItemsRepository;
import com.wissen.instantvendingmachine.repository.TrayComptRepository;
import com.wissen.instantvendingmachine.repository.TraysRepository;

@Service

public class TrayWeights {

	@Autowired
	private TrayComptRepository trayComptRepository;
	@Autowired
	private TraysRepository traysRepository;
	@Autowired
	private ItemsRepository itemsRepository;
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	public Map<Long, Float> fetchCurrentTrayWeights() {
		Map<Long, Float> currentWeights = new HashMap<>();
		List<TrayComptEntity> trayComp = trayComptRepository.findAll().stream().collect(Collectors.toList());
		for (TrayComptEntity trayComptEntity : trayComp) {
			long trayID = trayComptEntity.getTrayID();
			TraysEntity traysEntity = traysRepository.getOne(trayID);
			float trayWeight = traysEntity.getCurrentWeight();
			currentWeights.put(trayID, trayWeight);
		}
		return currentWeights;
	}

	public List<ItemsBoughtInfoDto> getItemPicked(List<UpdatingTrayWeightsDto> updatedWeights) throws Exception {
		float oldSum = 0;
		float newSum = 0;
		float checkoutAmount = 0;

		Map<Long, Float> currentWeights = fetchCurrentTrayWeights();

		List<ItemsBoughtInfoDto> boughtInfoDtos = new ArrayList<>();

		for (UpdatingTrayWeightsDto updatingTrayWeightsDto : updatedWeights) {

			long trayID = updatingTrayWeightsDto.getTrayID();

			float updatedTrayWeight = updatingTrayWeightsDto.getTrayWeight();
			float difference = updatedTrayWeight - currentWeights.get(trayID);
			ItemsBoughtInfoDto boughtInfoDto = new ItemsBoughtInfoDto();
			TraysEntity traysEntity = traysRepository.getOne(trayID);
			long itemID = traysEntity.getItemID();
			float price = itemsRepository.getOneByItemID(traysEntity.getItemID()).getItemPrice();

			float oldTrayWeight = traysEntity.getCurrentWeight();
			oldSum += oldTrayWeight;
			newSum += updatedTrayWeight;

			if (traysEntity.getQuantity() == 0) {
				throw new Exception(traysEntity.getItemID() + " is out of stock!!");
			}
			int numberOfItemsPicked = (int) (difference / (oldTrayWeight / traysEntity.getQuantity()));
			int newQuantity = traysEntity.getQuantity() + numberOfItemsPicked;
			boughtInfoDto.setItemID(traysEntity.getItemID());
			boughtInfoDto.setQuantity(Math.abs(numberOfItemsPicked));
			traysEntity.setQuantity(newQuantity);
			traysEntity.setCurrentWeight(updatedTrayWeight);
			boughtInfoDtos.add(boughtInfoDto);

			// filling order_items table
			OrderItemsEntity orderItemsEntity = new OrderItemsEntity();
			orderItemsEntity.setItemId(itemID);
			orderItemsEntity.setQuantity(numberOfItemsPicked);
			orderItemsRepository.save(orderItemsEntity);

			if (numberOfItemsPicked < 0) {
				boughtInfoDto.setAction("An item was picked");
				checkoutAmount += price;
				boughtInfoDto.setTotal(checkoutAmount);

			} else if (numberOfItemsPicked > 0) {
				boughtInfoDto.setAction("An item was added");
				checkoutAmount += 0;
				boughtInfoDto.setTotal(checkoutAmount);
			} else {
				boughtInfoDto.setAction("No action");
				checkoutAmount += 0;
				boughtInfoDto.setTotal(checkoutAmount);
			}

			traysRepository.save(traysEntity);
		}
		if (oldSum == newSum) {
			throw new Exception("You might have displaced items, or not picked an item.");
		}
		return boughtInfoDtos;
	}
}
