package com.project.traini8.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

//Entity class to represent a Training Center

@Entity
@Data //Lombok annotation for getters and setters
@NoArgsConstructor //Lombok annotation for no-args constructor
@AllArgsConstructor //Lombok annotation for all-args constructor
public class TrainingCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Auto increment primary key
	private Long id;
	
	@NotBlank //Makes sure the field is not empty
	@Size(max = 40) //Makes sure not to let name length exceed 40 characters
	private String centerName;
	
	@NotBlank
	@Size(min = 12, max = 12) //Makes sure that the code is exactly 12 characters
	private String centerCode;
	
	@Embedded //Embedded address entity as it has sub fields
	private Address address;
	
	private Integer studentCapacity; //stores the capacity of training center
	
	@ElementCollection //creates a separate table to store the list of courses for each TrainingCenter
	private List<String> coursesOffered;
	
	private Instant createdOn; //timestamps when center is created
	
	@Email //Checks for valid email format
	private String contactEmail;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number") //Checks for exactly 10 digit number
	private String contactPhone;
	
	//automatically sets the createdOn timestamp before persisting the entity
	@PrePersist
	public void prePersist() {
		this.createdOn = Instant.now();
	}
}
