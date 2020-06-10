package kosta.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = {"1. Test"})
public class SwaggerTestController {
	
	@ApiOperation(value="테스트기능", notes="swagger 자동생성을 테스트한다, 회원이름을 param으로 받아 field2개짜리 Member객체 반환")
	@RequestMapping("/test")
	public String test(@ApiParam(value="회원이름", required=true) @RequestParam String name) {
		
		return "";		
	}

}
