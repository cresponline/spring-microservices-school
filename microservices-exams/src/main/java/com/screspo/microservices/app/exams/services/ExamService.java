package com.screspo.microservices.app.exams.services;

import java.util.List;

import com.screspo.microservices.commons.exams.models.entity.Exam;
import com.screspo.microservices.commons.exams.models.entity.Subject;
import com.screspo.microservices.commons.services.CommonService;

public interface ExamService extends CommonService<Exam> {

	public List<Exam> findByName(String param);
	
	public Iterable<Subject> findAllSubjects();
}
