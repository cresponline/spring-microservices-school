package com.screspo.microservice.app.answers.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.screspo.microservice.app.answers.models.entity.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

}
