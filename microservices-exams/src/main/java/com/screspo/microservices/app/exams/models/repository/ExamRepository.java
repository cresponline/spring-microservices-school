package com.screspo.microservices.app.exams.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.screspo.microservices.commons.exams.models.entity.Exam;

public interface ExamRepository extends CrudRepository<Exam, Long> {
	
	@Query("select e from Exam e where e.name like %?1%")
	public List<Exam> findByName(String param);

}
