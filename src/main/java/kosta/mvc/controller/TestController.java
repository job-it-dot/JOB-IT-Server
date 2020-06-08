package kosta.mvc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestController {

	// 테스트용 컨트롤러
	@RequestMapping("/")
	public String sayHello() {
		return "HELLO WORLD";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestController.class, args);
	}
	
}
