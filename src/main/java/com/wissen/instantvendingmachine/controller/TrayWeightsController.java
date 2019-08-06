package com.wissen.instantvendingmachine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.instantvendingmachine.dto.UpdatingTrayWeightsDto;
import com.wissen.instantvendingmachine.service.TrayWeights;

@RestController
public class TrayWeightsController {
	@Autowired
	private TrayWeights trayWeights;

	@GetMapping("/trays_in_compartment")
	public ResponseEntity<Map<Long, Float>> displayingTrayWeights(@RequestParam String compartmentName) {

		return new ResponseEntity<>(trayWeights.fetchCurrentTrayWeights(compartmentName), HttpStatus.OK);
	}

	@GetMapping("/items_picked")
	public List<Long> gettingItemsPicked() {
		return trayWeights.getItemPicked();
	}

	@PostMapping("/enter_new_weights")
	public ResponseEntity<Map<Long, Float>> updatingTrayWeights(
			@RequestBody List<UpdatingTrayWeightsDto> updatedWeights) {
		return new ResponseEntity<>(trayWeights.enterUpdatedTrayWeights(updatedWeights), HttpStatus.OK);
	}

}
