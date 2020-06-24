package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Users;
import kosta.mvc.service.AdminserviceImpl;

@RequestMapping("/admin")
@ApiOperation("관리자 컨트롤러")
public class AdminController {
	
	@Autowired
	private AdminserviceImpl adminService;
	
	@ApiParam("유저 전체 조회")
	@GetMapping("/showAllUser")
	public List<Users> showAllUser() throws IOException {
		List<Users> list = adminService.selectUser();
		return list;
	}
	
	@ApiParam("유저 상세조회")
	@RequestMapping("/showUser")
	public Users showUser(@ApiParam("조회할 userId")Long userId) throws IOException {
		Users user = adminService.selectById(userId);
		return user;
	}
	
	@ApiParam("기업 목록 조회")
	@RequestMapping("/showAllCompany")
	public List<Companys> showAllCompany() throws IOException{
		List<Companys> list = adminService.selectCompany();
		return list;
	}
	
	@ApiParam("기업 회원 상세 조회")
	@RequestMapping("/showCompany")
	public Companys showCompany(@ApiParam("조회할 기업 ID")Long companyId) throws IOException {
		Companys company = adminService.selelctCompanyId(companyId);
		return company;
	}
	
	//기업강제탈퇴
	@ApiParam("기업 강제 탈퇴")
	@RequestMapping("/deleteCompany")
	public String deleteCompany(@ApiParam("탈퇴시킬 기업 ID")Long companyId) throws NotFoundException, IOException {
		int result = adminService.companysWithdrawal(companyId);
		String msg = "탈퇴 불가";
		if(result == 1) {
			msg = "탈퇴 완료.";
		}
		return msg;
	}
	
	//회원 강제 탈퇴
	@ApiParam("회원강제탈퇴")
	@RequestMapping("/deleteUser")
	public String deleteUser(@ApiParam("탈퇴할 일반 회원 ID")Long userId) throws NotFoundException, IOException {
		 int result = adminService.memberWithdrawal(userId);
		 String msg = "탈퇴 불가";
		 if(result == 1) {
			 msg = "탈퇴 완료";
		 }
		 return msg;
	}
	
	@ApiParam("기업회원 승인")
	@RequestMapping("/approveCompany")
	public String approveCompany(@ApiParam("승인활 기업 ID")Long companyId) throws IOException {
		int result = adminService.companyApproval(companyId);
		String msg = "승인 오류";
		if(result == 1) {
			msg = "승인 완료";
		}
		return msg;
	}
	
	
}
