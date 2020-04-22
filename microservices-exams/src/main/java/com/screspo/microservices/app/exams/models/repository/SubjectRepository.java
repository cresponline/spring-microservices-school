package com.screspo.microservices.app.exams.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.screspo.microservices.commons.exams.models.entity.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

}
