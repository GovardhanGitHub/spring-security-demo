package com.example.demo.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Tutorial;

public interface TutorialService {
	
	public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial);
	public ResponseEntity<Tutorial> updateTutorial(long id, Tutorial tutorial);
	public List<Tutorial> findAllTutorials();
	public ResponseEntity<List<Tutorial>> findByPublished();
	public ResponseEntity<List<Tutorial>> getAllTutorials(String title);
	public ResponseEntity<HttpStatus> deleteAllTutorials();

	public ResponseEntity<HttpStatus> deleteTutorial(Long id);
	ResponseEntity<Tutorial> getTutorialById(long id);

}
