package com.screspo.microservice.app.answers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.screspo.microservice.app.answers.models.entity.Answer;
import com.screspo.microservice.app.answers.services.AnswerService;

@RestController
public class AnswerController {
	
	@Autowired
	private AnswerService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Iterable<Answer> answers){
		Iterable<Answer> answersDb = service.saveAll(answers);
		return ResponseEntity.status(HttpStatus.CREATED).body(answersDb);
	}
	
	@GetMapping("/student/{studentId}/exam/{examId}")
	public ResponseEntity<?> findAnswerByStudentAndExam(@PathVariable Long studentId, @PathVariable Long examId) {
		Iterable<Answer> answers = service.findAnswerByStudentByExam(studentId, examId);
		return ResponseEntity.ok(answers);
	}
	
	@GetMapping("/student/{studentId}/answered-exams")
	public ResponseEntity<?> findExamsIdsWithAnswersByStudent(@PathVariable Long studentId){
		Iterable<Long> examsIds = service.findExamsIdsWithAnswersByStudent(studentId);
		return ResponseEntity.ok(examsIds);
	}		

}
