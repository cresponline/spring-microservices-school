package com.screspo.microservice.app.answers.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.screspo.microservices.app.commons.students.models.entity.Student;
import com.screspo.microservices.commons.exams.models.entity.Question;

import lombok.Data;

@Data
@Entity
@Table(name="Answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Question question;

}
