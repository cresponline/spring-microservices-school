package com.screspo.microservices.app.users.services;

import java.util.List;

import com.screspo.microservices.app.commons.students.models.entity.Student;
import com.screspo.microservices.commons.services.CommonService;

public interface StudentService extends CommonService<Student>{
	
	public List<Student> findByNameOrSurname(String param);
}
