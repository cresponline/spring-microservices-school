package com.screspo.microservices.app.exams.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.screspo.microservices.app.exams.models.repository.ExamRepository;
import com.screspo.microservices.commons.exams.models.entity.Exam;
import com.screspo.microservices.commons.services.CommonServiceImpl;

@Service
public class ExamServiceImpl extends CommonServiceImpl<Exam, ExamRepository> implements ExamService {

	@Override
	@Transactional(readOnly = true)
	public List<Exam> findByName(String param) {
		return repository.findByName(param);
	}

	
}
