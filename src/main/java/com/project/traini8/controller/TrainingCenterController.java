package com.project.traini8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.traini8.model.TrainingCenter;
import com.project.traini8.service.TrainingCenterService;

import jakarta.validation.Valid;

//Rest Controller to manage trainingcenter api endpoints

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {
	
	@Autowired
	private TrainingCenterService service;
	
	//Endpoint to create a new training center
	@PostMapping
	public TrainingCenter createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
		return service.createTrainingCenter(trainingCenter);
	}
	
	//Endpoint to retrieve training centers with optional filters
	@GetMapping
	public List<TrainingCenter> getTrainingCenters(
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String course) {
		return service.getTrainingCenters(city, state, course);
	}
	
}
