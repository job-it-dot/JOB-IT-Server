package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javassist.NotFoundException;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Recruit;
import kosta.mvc.service.RecruitService;

@RestController
@RequestMapping("/recruit")
@Api(tags = {"채용정보 관련 컨트롤러 입니다."})
public class RecruitController {
	
	@Autowired
	private RecruitService recruitService;
	
	@RequestMapping("/selectAll")
	@ApiOperation("채용정보 목록보기")
	public List<Recruit> selectAllRecruit() {
		List<Recruit> list = recruitService.selectAllRecruitInfoList();
//		Recruit re = new Recruit();
//		for(Recruit r : list) {
//			r.getCompany().getCompanyName();
//			Companys c = new Companys();
//			c.setCompanyName(r.getCompany().getCompanyName());
//			c.setCompanyPoints(r.getCompany().getCompanyPoints());
//			re.setCompany(c);
//		}
		return list;
	}
	
	@GetMapping("/readRecruit")
	@ApiOperation("채용정보 상세보기")
	public Recruit readRecruit(@ApiParam("각 채용공고id")Long recruitId) throws NotFoundException {
		Recruit recruit = recruitService.selectRecruitById(recruitId);
		return recruit;
	}
	
	//관심기업 등록하기
	@GetMapping("/register")
	@ApiOperation("관심기업 등록하기")
	public String registerInterestCompany(@ApiParam("기업ID")Long companyId, @ApiParam("유저ID")Long userId) {
		String msg;
		int result = recruitService.registerInterestCompany(companyId, userId);
		if(result == 1) {
			msg = "등록되었습니다.";
		}else {
			msg = "등록 취소 되었습니다.";
		}
		
		return msg;
	}
	
	//관심 기업 해지하기
	@GetMapping("/cancle")
	@ApiOperation("관심기업 해지하기")
	public String cancleInterestCompany(@ApiParam("팔로우ID(관심기업)")Long followId) {
		String msg;
		int result = recruitService.cancleInterestCompany(followId);
		if(result == 1) {
			msg = "취소 되었습니다.";
		}else {
			msg = "취소 되지 않았습니다.";
		}
		return msg;
	}
	
	//관심 기업 조회하기
	@GetMapping("/showAllCompany")
	public List<Companys> selectCompany(Long userId){
		List<Companys> list = recruitService.selectAllInterestCompany(userId);
		
		return list;
	}
	
	
	
	
	@ExceptionHandler(NotFoundException.class)
	@ApiOperation("에러메시지 출력 메소드")
	public String error(@ApiParam("오류파라미터")Exception e) {
		return e.getMessage();
		
	}
	
	
}
