package com.wissen.instantvendingmachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.instantvendingmachine.entity.TrayComptEntity;
import com.wissen.instantvendingmachine.repository.TrayComptRepository;

@Service
public class CompartmentName {

	@Autowired
	private TrayComptRepository trayComptRepository;

	public TrayComptEntity getCompartment(long trayID) {
		return trayComptRepository.getOneByTrayID(trayID);

	}

}
