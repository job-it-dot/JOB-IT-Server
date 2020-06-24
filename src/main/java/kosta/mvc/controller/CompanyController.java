package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Recruit;
import kosta.mvc.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@ApiOperation(value = "이메일 중복체크", notes = "return : 0-중복아님 / 1-중복")
	@RequestMapping("/idDuplicate")
	public int idDuplicate(@ApiParam("가입할 이메일")String memberEmail) throws IOException {
		return companyService.duplicateEmail(memberEmail);
	}
	
	@ApiOperation(value = "기업 회원가입", notes = "return : 0-가입실패 / 1-가입성공")
	@RequestMapping("/join")
	public int join(@ApiParam("기업 가입 정보")Companys company) throws IOException {
		if(companyService.duplicateEmail(company.getMember().getMemberEmail()) == 1) {
			throw new RuntimeException("이미 사용중인 이메일 입니다.");
		}
		return companyService.insertCompany(company);
	}
	
	@ApiOperation(value = "기업 정보 조회")
	@RequestMapping("/info")
	public Companys info(HttpSession session) throws IOException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.selectCompanyById(companyId);
	}
	
	@ApiOperation(value = "비밀번호 확인", notes = "return : 0-비밀번호 불일치 / 1-일치")
	@RequestMapping("/checkPwd")
	public int checkPwd(HttpSession session, @ApiParam("입력받은 비밀번호")String password) throws IOException, NotFoundException{
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.checkPassword(companyId, password);
	}
	
	@ApiOperation(value = "기업정보(회원정보) 수정", notes = "return : 0-수정실패 / 1-성공")
	@RequestMapping("/updateInfo")
	public int updateInfo(@ApiParam("수정할 기업 정보")Companys company) throws IOException, NotFoundException {
		return companyService.updateCompany(company);
	}
	
	@ApiOperation(value = "기업회원이 올린 채용공고 목록 조회", notes = "return : 공고 list")
	@RequestMapping("/recruitList")
	public List<Recruit> recruitList(HttpSession session) throws IOException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.selectRecruitByCompanyId(companyId);
	}
	
//	@ApiOperation(value = "채용공고 상세보기", notes = "return : 채용공고내용")
//	@RequestMapping("/recruit")
	
	@ExceptionHandler(IOException.class)
	@ApiOperation("에러메시지 출력 메소드")
	public String ioError(@ApiParam("오류파라미터") Exception e) {
		return e.getMessage();
	}

	@ExceptionHandler(RuntimeException.class)
	@ApiOperation("에러메시지 출력 메소드")
	public String runtimeError(@ApiParam("오류파라미터") Exception e) {
		return e.getMessage();
	}
}
