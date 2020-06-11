package kosta.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.bitbucket.tek.nik.simplifiedswagger", "kosta.mvc"})
public class ProjectJobItApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJobItApplication.class, args);
	}

}
