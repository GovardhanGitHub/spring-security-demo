package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Tutorial {
	
	

	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;

	private String description;

	private boolean published;

	

}
