package com.dmwlabs.CheatsheetAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication
@ComponentScan(value = "config")
@ComponentScan(value = "controllers")
@EnableJpaRepositories("repositories")
@EntityScan("entities")
public class CheatsheetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheatsheetApiApplication.class, args);
	}

}
