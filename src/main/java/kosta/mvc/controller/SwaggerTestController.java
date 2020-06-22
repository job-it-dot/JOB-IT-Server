package kosta.mvc.controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Members;

@RestController
@Api(tags = {"1. 테스트를 합니다"})
public class SwaggerTestController {
	
	@PostMapping("/test")
	@ApiOperation("테스트 메소드")
	public Members test(@ApiParam("회원이름")String name) {
		
		return new Members();		
	}
	
	@PostMapping("/test2")
	@ApiOperation("두번째 테스트 메소드")
	public Apply test2(@ApiParam("status는 상태(0:죽음, 1:살았음)")int status) {
		return new Apply();
	}

}
