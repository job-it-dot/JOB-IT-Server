package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javassist.NotFoundException;
import kosta.mvc.domain.Recruit;
import kosta.mvc.service.RecruitService;

@RestController
@RequestMapping("/recruit")
@Api(tags = {"채용정보 관련 컨트롤러 입니다."})
public class RecruitController {
	
	@Autowired
	private RecruitService recruitService;
	
	@PostMapping("/selectAll")
	@ApiOperation("채용정보 목록보기")
	public List<Recruit> selectAllRecruit() {
		List<Recruit> list = recruitService.selectAllRecruitInfoList();
		return list;
	}
	
	@PostMapping("/readRecruit")
	@ApiOperation("채용정보 상세보기")
	public Recruit readRecruit(@ApiParam("각 채용공고id")Long recruitId) throws NotFoundException {
		Recruit recruit = recruitService.selectRecruitById(recruitId);
		return recruit;
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ApiOperation("에러메시지 출력 메소드")
	public String error(@ApiParam("오류파라미터")Exception e) {
		return e.getMessage();
		
	}
	
	
}
