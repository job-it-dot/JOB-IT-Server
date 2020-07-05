package kosta.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.DTO.MembersDTO;
import kosta.mvc.domain.Members;
import kosta.mvc.service.LoginService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login11")
	public Map<String, Object> login(@RequestBody MembersDTO membersDTO){
		
		Members member = new Members(membersDTO);
		return loginService.login(member);
	}
		
}
