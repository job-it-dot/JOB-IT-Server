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

import kosta.mvc.domain.Members;
import kosta.mvc.domain.Users;
import kosta.mvc.service.CompanyService;
import kosta.mvc.service.UserService;


@RestController
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/index")
	public Map<String, Object> loginSuccess(@AuthenticationPrincipal Members member) throws IOException, NotFoundException{
		Authentication   obj=SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println("obj = " + obj );
		System.out.println("member = " + member );
		
		Map<String, Object> map = new HashMap<>();

		switch(member.getMemberStatus()) {
		case 1:
			map.put("memberType", "user");
			map.put("user", userService.selectUserByMemberId(member.getMemberId()));
			break;
		case 2:
			map.put("memberType", "company");
			map.put("company", companyService.selectCompanyByMemberId(member.getMemberId()));
			break;
		case 3:
			map.put("memberType", "admin");
			break;
		}
		
		
		
		return map;
	}

}


