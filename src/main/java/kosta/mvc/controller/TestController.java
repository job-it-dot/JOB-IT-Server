package kosta.mvc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"1. Test"})
public class TestController {

	// 테스트용 컨트롤러
	@RequestMapping("/")
	@ApiOperation(value="테스트기능2", notes="swagger2 자동생성을 테스트한다")
	public String sayHello() {
		return "HELLO WORLD";
	}
	
	
}
