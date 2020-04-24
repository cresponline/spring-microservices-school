package com.screspo.microservice.app.answers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.screspo.microservice.app.answers.models.entity.Answer;
import com.screspo.microservice.app.answers.models.repository.AnswerRepository;

@Service
public class AnswerServiceImp implements AnswerService{

	@Autowired
	private AnswerRepository repository;
	
	@Override
	@Transactional
	public Iterable<Answer> saveAll(Iterable<Answer> answers) {
		return repository.saveAll(answers);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Answer> findAnswerByStudentByExam(Long studentId, Long examId) {
		return repository.findAnswerByStudentByExam(studentId, examId);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentid) {
		return repository.findExamsIdsWithAnswersByStudent(studentid);
	}

}
