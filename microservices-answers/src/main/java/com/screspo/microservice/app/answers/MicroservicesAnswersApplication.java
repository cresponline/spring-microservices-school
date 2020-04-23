package com.screspo.microservice.app.answers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.screspo.microservice.app.answers.models.entity",
			 "com.screspo.microservices.app.commons.students.models.entity",
			 "com.screspo.microservices.commons.exams.models.entity"})
public class MicroservicesAnswersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesAnswersApplication.class, args);
	}

}
