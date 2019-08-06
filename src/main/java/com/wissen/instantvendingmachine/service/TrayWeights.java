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
import com.wissen.instantvendingmachine.entity.TrayComptEntity;
import com.wissen.instantvendingmachine.entity.TraysEntity;
import com.wissen.instantvendingmachine.repository.TrayComptRepository;
import com.wissen.instantvendingmachine.repository.TraysRepository;

@Service

public class TrayWeights {

	@Autowired
	private TrayComptRepository trayComptRepository;
	@Autowired
	private TraysRepository traysRepository;

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

	public List<ItemsBoughtInfoDto> getItemPicked(List<UpdatingTrayWeightsDto> updatedWeights) {
		float oldSum = 0;
		float newSum = 0;

		Map<Long, Float> currentWeights = fetchCurrentTrayWeights();

		List<ItemsBoughtInfoDto> boughtInfoDtos = new ArrayList<>();

		for (UpdatingTrayWeightsDto updatingTrayWeightsDto : updatedWeights) {

			long trayID = updatingTrayWeightsDto.getTrayID();
			float updatedTrayWeight = updatingTrayWeightsDto.getTrayWeight();
			float difference = updatedTrayWeight - currentWeights.get(trayID);
			ItemsBoughtInfoDto boughtInfoDto = new ItemsBoughtInfoDto();
			TraysEntity traysEntity = traysRepository.getOne(trayID);

			float oldTrayWeight = traysEntity.getCurrentWeight();
			oldSum += oldTrayWeight;
			newSum += updatedTrayWeight;

			int numberOfItemsPicked = (int) (difference / (oldTrayWeight / traysEntity.getQuantity()));
			int newQuantity = traysEntity.getQuantity() + numberOfItemsPicked;
			boughtInfoDto.setItemID(traysEntity.getItemID());
			boughtInfoDto.setQuantity(Math.abs(numberOfItemsPicked));
			traysEntity.setQuantity(newQuantity);
			traysEntity.setCurrentWeight(updatedTrayWeight);
			boughtInfoDtos.add(boughtInfoDto);

			if (numberOfItemsPicked < 0) {
				boughtInfoDto.setAction("An item was picked");

			} else if (numberOfItemsPicked > 0) {
				boughtInfoDto.setAction("An item was added");
			} else {
				boughtInfoDto.setAction("No action");
			}

			traysRepository.save(traysEntity);
		}
		if (oldSum == newSum) {
			throw new IllegalArgumentException("You might have displaced items");
		}
		return boughtInfoDtos;
	}
}
