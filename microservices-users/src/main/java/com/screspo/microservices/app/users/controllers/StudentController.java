package com.screspo.microservices.app.users.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.screspo.microservices.app.commons.students.models.entity.Student;
import com.screspo.microservices.app.users.services.StudentService;
import com.screspo.microservices.commons.controllers.CommonController;

@RestController
public class StudentController extends CommonController<Student, StudentService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@Valid @RequestBody Student student, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return validate(result);
		}
		
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
	public ResponseEntity<?> filter(@PathVariable String param){
		return ResponseEntity.ok(service.findByNameOrSurname(param));
	}

	@PostMapping("create-with-photo")
	public ResponseEntity<?> createWithPhoto(@Valid Student student, BindingResult result,
			@RequestParam MultipartFile file) throws IOException {
	
		if (!file.isEmpty()) {
			student.setPhoto(file.getBytes());
		}
		
		return super.create(student, result);
	}
	
	@PutMapping("/edit-with-photo/{id}")
	public ResponseEntity<?> editWithPhoto(@Valid Student student, 
			BindingResult result, @PathVariable Long id, @RequestParam MultipartFile file) throws IOException{
		
		if(result.hasErrors()) {
			return validate(result);
		}
		
		Optional<Student> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Student studentDb = optional.get();
		studentDb.setName(student.getName());
		studentDb.setSurname(student.getSurname());
		studentDb.setMail(student.getMail());
		
		if (!file.isEmpty()) {
			studentDb.setPhoto(file.getBytes());
		}
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.save(studentDb));
	}
	
	
}
