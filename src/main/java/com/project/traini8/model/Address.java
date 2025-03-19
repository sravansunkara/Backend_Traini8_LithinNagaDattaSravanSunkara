package com.project.traini8.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//Represents an embedded address object within trainingcenter

@Data
@Embeddable //Marks this as an embedded object within another entity
public class Address {
	
	@NotBlank //Ensures field is not empty
	private String detailedAddress;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String pincode;
}
