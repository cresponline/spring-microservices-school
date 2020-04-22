package com.screspo.microservices.commons.exams.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JsonIgnoreProperties(value = {"subSubjects"})
	@ManyToOne(fetch = FetchType.LAZY)
	private Subject superSubject;
	
	@JsonIgnoreProperties(value = {"superSubject"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "superSubject", cascade = CascadeType.ALL)
	private List<Subject> subSubjects;
	
	public Subject() {
		this.subSubjects = new ArrayList<>();
	}

}
