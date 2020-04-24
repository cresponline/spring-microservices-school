
package com.screspo.microservices.app.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.screspo.microservices.app.courses.clients.AnswerFeignClient;
import com.screspo.microservices.app.courses.models.entity.Course;
import com.screspo.microservices.app.courses.models.repository.CourseRepository;
import com.screspo.microservices.commons.services.CommonServiceImpl;

@Service
public class CourseServiceImp extends CommonServiceImpl<Course, CourseRepository> implements CourseService {
	
	@Autowired
	private AnswerFeignClient client;
	
	@Override
	@Transactional(readOnly=true)
	public Course findCourstByStudentId(Long id) {
		return repository.findCourstByStudentId(id);
	}

	@Override
	public Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentId) {
		return client.findExamsIdsWithAnswersByStudent(studentId);
	}
}
