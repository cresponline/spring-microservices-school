package com.screspo.microservice.app.answers.services;

import com.screspo.microservice.app.answers.models.entity.Answer;

public interface AnswerService {

	public Iterable<Answer> saveAll(Iterable<Answer> answers);
}
