package com.screspo.microservices.app.users.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.screspo.microservices.app.commons.students.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("select s from Student s where s.name like %?1% or s.surname like %?1%")
	public List<Student> findByNameOrSurname(String param);
}
