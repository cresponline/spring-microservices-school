package com.screspo.microservices.app.courses.services;

import org.springframework.stereotype.Service;

import com.screspo.microservices.app.courses.models.entity.Course;
import com.screspo.microservices.commons.services.CommonService;

@Service
public interface CourseService extends CommonService<Course> {
	public Course findCourstByStudentId(Long id);
	
}
