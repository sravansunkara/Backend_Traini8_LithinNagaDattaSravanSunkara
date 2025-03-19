package com.project.traini8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.project.traini8.model.TrainingCenter;
import com.project.traini8.repository.TrainingCenterRepository;

import jakarta.persistence.criteria.Predicate;

//service class handling business logic for training center

@Service
public class TrainingCenterService {
	
	@Autowired
	public TrainingCenterRepository repository;
	
	
	//saves a new training center into the database
	public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
		return repository.save(trainingCenter);
	}
	
	//retrieves training centers based on optimal filters (city, state, course)
	public List<TrainingCenter> getTrainingCenters(String city, String state, String course) {
		Specification<TrainingCenter> spec  = (root, query, cb) -> {
			Predicate predicate = cb.conjunction();
			
			if (city != null && !city.isEmpty()) {
				predicate  = cb.and(predicate, cb.equal(root.get("address").get("city"), city));
			}
			if (state != null && !state.isEmpty()) {
				predicate = cb.and(predicate, cb.equal(root.get("address").get("state"), state));
			}
			
			if (course != null && !course.isEmpty()) {
				predicate = cb.and(predicate, cb.isMember(course, root.get("coursesOffered")));
			}
			
			return predicate;
		};
		
		return repository.findAll(spec);
	}

}
