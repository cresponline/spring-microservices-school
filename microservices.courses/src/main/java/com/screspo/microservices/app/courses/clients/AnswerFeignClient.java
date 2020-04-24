package com.screspo.microservices.app.courses.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="micreoservices-answers")
public interface AnswerFeignClient {

	@GetMapping("/student/{studentId}/answered-exams")
	public Iterable<Long> findExamsIdsWithAnswersByStudent(@PathVariable Long studentId);
}
