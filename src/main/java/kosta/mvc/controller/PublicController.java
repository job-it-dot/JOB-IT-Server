package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.domain.Recruit;
import kosta.mvc.service.PublicService;

@Controller
@Api(tags = {"PublicMethod. 로그인 불필요."})
@RequestMapping("/users")
public class PublicController {
	
	@Autowired
	private PublicService publicService;

	
	@RequestMapping("/search")
	@ApiOperation("채용공고 검색 Method. Integer의 경우 null, String의경우 null혹은 empty이면 조건에서 제외됨")
	public List<Recruit> searchRecruit(
			@ApiParam("입력받은 String을 포함한 회사명")String companyName, 
			@ApiParam("요구경력 년수가 입력받은 integer 이하")Integer career, 
			@ApiParam("입력받은 String을 포함한 근무지 주소")String addr, 
			@ApiParam("요구학력단계(RequiredEdu.reqEduGrade)가 입력된 integer이하")Integer edu,
			@ApiParam("select-box로 선택된 회사type이 일치")String companyType, 
			@ApiParam("예상 급여(연봉)가 integer 이상")Integer salary, 
			@ApiParam("select-box로 선택된 position명이 일치")String position){
		
		return publicService.searchRecruit(companyName, career, addr, edu, companyType, salary, position);
		
	}
}
