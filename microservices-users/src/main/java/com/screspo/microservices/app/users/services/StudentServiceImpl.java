package com.screspo.microservices.app.users.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.screspo.microservices.app.commons.students.models.entity.Student;
import com.screspo.microservices.app.users.models.repository.StudentRepository;
import com.screspo.microservices.commons.services.CommonServiceImpl;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

	@Override
	@Transactional(readOnly = true)
	public List<Student> findByNameOrSurname(String param) {
		return repository.findByNameOrSurname(param);
	}
	
}
