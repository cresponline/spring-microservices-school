package com.screspo.microservices.app.exams.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.screspo.microservices.app.exams.services.ExamService;
import com.screspo.microservices.commons.controllers.CommonController;
import com.screspo.microservices.commons.exams.models.entity.Exam;

@RestController
public class ExamController extends CommonController<Exam, ExamService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Exam exam, @PathVariable Long id) {
		Optional<Exam> optional = service.findById(id);
		
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Exam examDb =  optional.get();
		examDb.setName(exam.getName());
		
		examDb.getQuestions()
			.stream()
			.filter(qdb -> !exam.getQuestions().contains(qdb))
			.forEach(examDb::removeQuestion);
		
		examDb.setQuestions(exam.getQuestions());
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.save(examDb));
	}
	
	@GetMapping("/filter/{param}")
	public ResponseEntity<?> filter(@PathVariable String param) {
		return ResponseEntity.ok(service.findByName(param));
	}

}
 