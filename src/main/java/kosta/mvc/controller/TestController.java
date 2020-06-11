package kosta.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	// 테스트용 컨트롤러
	@RequestMapping("/")
	public String sayHello() {
		return "HELLO WORLD";
	}
	
	
}
