package com.screspo.microservices.app.users.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.screspo.microservices.app.commons.students.models.entity.Student;
import com.screspo.microservices.app.users.services.StudentService;
import com.screspo.microservices.commons.controllers.CommonController;

@RestController
public class StudentController extends CommonController<Student, StudentService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Student student, @PathVariable Long id) {
		Optional<Student> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Student studentDb = optional.get();
		studentDb.setName(student.getName());
		studentDb.setSurname(student.getSurname());
		studentDb.setMail(student.getMail());
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.save(studentDb));
	}
	
	@GetMapping("/filter/{param}")
	public ResponseEntity<?> filter(@PathVariable String param) {
		return ResponseEntity.ok(service.findByNameOrSurname(param));
	}
}
