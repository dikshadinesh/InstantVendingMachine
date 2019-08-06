package com.wissen.instantvendingmachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.instantvendingmachine.entity.TrayComptEntity;
import com.wissen.instantvendingmachine.entity.TraysEntity;
import com.wissen.instantvendingmachine.repository.TraysRepository;

@Service
public class SelectItem {

	@Autowired
	private TraysRepository traysRepository;
	@Autowired
	private CompartmentName compartmentName;

	public void decrementQuantity(long itemID) {
		TraysEntity trays = traysRepository.getOneByItemID(itemID);
		trays.setQuantity(trays.getQuantity() - 1);
		traysRepository.save(trays);
	}

	public String getCompartmentName(long itemID) {
		TraysEntity trays = traysRepository.getOneByItemID(itemID);
		long trayID = trays.getTrayID();
		TrayComptEntity compartment = compartmentName.getCompartment(trayID);
		if (compartment == null) {
			return null;
		}
		return compartment.getCompartment();
	}

}
