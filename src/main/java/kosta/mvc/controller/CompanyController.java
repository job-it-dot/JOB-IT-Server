package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.domain.Companys;
import kosta.mvc.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@ApiOperation(value = "기업 정보 조회")
	@RequestMapping("/companyInfo")
	public Companys companyInfo(HttpSession session) throws IOException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.selectCompanyById(companyId);
	}
	
	@ExceptionHandler(IOException.class)
	@ApiOperation("에러메시지 출력 메소드")
	public String error(@ApiParam("오류파라미터") Exception e) {
		return e.getMessage();
	}
}
