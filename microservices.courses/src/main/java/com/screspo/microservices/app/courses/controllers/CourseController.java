package com.screspo.microservices.app.courses.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.screspo.microservices.app.commons.students.models.entity.Student;
import com.screspo.microservices.app.courses.models.entity.Course;
import com.screspo.microservices.app.courses.services.CourseService;
import com.screspo.microservices.commons.controllers.CommonController;
import com.screspo.microservices.commons.exams.models.entity.Exam;

@RestController
public class CourseController extends CommonController<Course, CourseService> {
	
	@PutMapping("/id")
	public ResponseEntity<?> edit(@Valid @RequestBody Course course, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return validate(result);
		}
		
		Optional<Course> optional = this.service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course dbCourse = optional.get();
		dbCourse.setName(course.getName());
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbCourse));
	}
	
	@PutMapping("/{id}/assign-students")
	public ResponseEntity<?> assignStudents(@RequestBody List<Student> students, @PathVariable Long id){
		
		Optional<Course> optional = this.service.findById(id);
		
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course dbCourse = optional.get();
		
		students.forEach(s -> {
			dbCourse.addStudent(s);
		});
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbCourse));
	}
	
	@PutMapping("/{id}/remove-student")
	public ResponseEntity<?> removeStudent(@RequestBody Student student, @PathVariable Long id){
		
		Optional<Course> optional = this.service.findById(id);
		
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course dbCourse = optional.get();
		
		dbCourse.removeStudent(student);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbCourse));
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> findByStudentId(@PathVariable Long id){
		
		Course course = service.findCourstByStudentId(id);
		
		return ResponseEntity.ok(course);
	}
	
	@PutMapping("/{id}/assign-exams")
	public ResponseEntity<?> assignExamms(@RequestBody List<Exam> exams, @PathVariable Long id){
		
		Optional<Course> optional = this.service.findById(id);
		
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course dbCourse = optional.get();
		
		exams.forEach(e -> {
			dbCourse.addExam(e);
		});
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbCourse));
	}
	
	@PutMapping("/{id}/remove-exam")
	public ResponseEntity<?> removeExam(@RequestBody Exam exam, @PathVariable Long id){
		
		Optional<Course> optional = this.service.findById(id);
		
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course dbCourse = optional.get();
		
		dbCourse.removeExam(exam);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.service.save(dbCourse));
	}

}
