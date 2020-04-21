
package com.screspo.microservices.app.courses.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.screspo.microservices.app.courses.models.entity.Course;
import com.screspo.microservices.app.courses.models.repository.CourseRepository;
import com.screspo.microservices.commons.services.CommonServiceImpl;

@Service
public class CourseServiceImp extends CommonServiceImpl<Course, CourseRepository> implements CourseService {
	
	@Transactional(readOnly=true)
	public Course findCourstByStudentId(Long id) {
		return repository.findCourstByStudentId(id);
	}
}
