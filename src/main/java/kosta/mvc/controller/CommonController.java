package kosta.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kosta.mvc.DTO.LoginResultDTO;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Users;
import kosta.mvc.service.CompanyService;
import kosta.mvc.service.UserService;

@Api("로그인결과")
@RestController
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/index")
	public LoginResultDTO loginSuccess(@AuthenticationPrincipal Members member) throws IOException, NotFoundException{
		Authentication   obj=SecurityContextHolder.getContext().getAuthentication();
		
//		System.out.println("obj = " + obj );
//		System.out.println("member = " + member );
//		

		LoginResultDTO result = new LoginResultDTO();
		
		switch(member.getMemberStatus()) {
		case 1:
			result.setMemberType("user");
			result.setUser(userService.selectUserByMemberId(member.getMemberId()));
			break;
		case 2:
			result.setMemberType("company");
			result.setCompany(companyService.selectCompanyByMemberId(member.getMemberId()));
			break;
		case 3:
			result.setMemberType("admin");
			break;
		}
		
		return result;
	}

}


