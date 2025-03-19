package com.project.traini8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.project.traini8.model.TrainingCenter;

//Repository interface for TrainingCenter entity

//JPArepository provides basic CRUD methods

//JPASpecificationExecutor allows dynamic filtering queries

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long>, JpaSpecificationExecutor<TrainingCenter> {

}
