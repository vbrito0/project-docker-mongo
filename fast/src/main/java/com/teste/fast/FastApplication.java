package com.teste.fast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableMongoRepositories
@EnableAutoConfiguration
@EnableSwagger2
@OpenAPIDefinition
@Configuration
public class FastApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastApplication.class, args);
	}

}
