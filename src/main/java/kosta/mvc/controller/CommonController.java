package kosta.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.domain.Members;
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
	public Map<String, Object> loginSuccess(@AuthenticationPrincipal Members member){
		Authentication   obj=SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println("obj = " + obj );
		System.out.println("member = " + member );
		//Members member = (Members)(obj);
		
		Map<String, Object> map = new HashMap<>();
		map.put("aa", "10");
		
	

		
		return map;
	}

}


