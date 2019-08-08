package com.wissen.instantvendingmachine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.instantvendingmachine.dto.ItemsBoughtInfoDto;
import com.wissen.instantvendingmachine.dto.UpdatingTrayWeightsDto;
import com.wissen.instantvendingmachine.service.TrayWeights;

@RestController
public class TrayWeightsController {
	@Autowired
	private TrayWeights trayWeights;

	@GetMapping("/trays_current_weights")
	public ResponseEntity<Map<Long, Float>> displayingTrayWeights() {
		return new ResponseEntity<>(trayWeights.fetchCurrentTrayWeights(), HttpStatus.OK);
	}

	@PostMapping("/pick_items")
	public ResponseEntity<List<ItemsBoughtInfoDto>> gettingItemsPicked(
			@RequestBody List<UpdatingTrayWeightsDto> updatedWeights) throws Exception {
		return new ResponseEntity<>(trayWeights.getItemPicked(updatedWeights), HttpStatus.OK);
	}

}
