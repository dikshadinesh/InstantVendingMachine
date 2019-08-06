package com.wissen.instantvendingmachine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	Map<Long, Float> currentWeights = new HashMap<>();
	Map<Long, Float> compartmentUpdatedWeights = new HashMap<>();
	List<Long> itemsPicked = new ArrayList<>();

	public Map<Long, Float> enterUpdatedTrayWeights(List<UpdatingTrayWeightsDto> updatedWeights) {
		compartmentUpdatedWeights.clear();
		for (UpdatingTrayWeightsDto updatingTrayWeightsDto : updatedWeights) {
			TraysEntity traysEntity = traysRepository.getOne(updatingTrayWeightsDto.getTrayID());
			traysEntity.setCurrentWeight(updatingTrayWeightsDto.getTrayWeight());
			compartmentUpdatedWeights.put(updatingTrayWeightsDto.getTrayID(), updatingTrayWeightsDto.getTrayWeight());
		}

		return compartmentUpdatedWeights;
	}

	public Map<Long, Float> fetchCurrentTrayWeights(String compartmentName) {
		compartmentUpdatedWeights.clear();
		List<TrayComptEntity> trayComp = trayComptRepository.findAll().stream()
				.filter(compartment -> compartment.getCompartment().equalsIgnoreCase(compartmentName))
				.collect(Collectors.toList());
		for (TrayComptEntity trayComptEntity : trayComp) {
			long trayID = trayComptEntity.getTrayID();
			TraysEntity traysEntity = traysRepository.getOne(trayID);
			float trayWeight = traysEntity.getCurrentWeight();

			currentWeights.put(trayID, trayWeight);
		}
		return currentWeights;

	}

	public List<Long> getItemPicked() {
		itemsPicked.clear();
		for (Long key : compartmentUpdatedWeights.keySet()) {
			if (currentWeights.containsKey(key)) {
				float difference = compartmentUpdatedWeights.get(key) - currentWeights.get(key);
				if (difference != 0) {
					long trayID = key;
					TraysEntity traysEntity = traysRepository.getOne(trayID);
					int numberOfItemsPicked = (int) (difference
							/ (traysEntity.getCurrentWeight() / traysEntity.getQuantity()));
					traysEntity.setQuantity(traysEntity.getQuantity() - numberOfItemsPicked);
					itemsPicked.add(traysEntity.getItemID());
				}
			}
		}
		return itemsPicked;
	}

}
