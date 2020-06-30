package kosta.mvc.controller;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.domain.Users;
import kosta.mvc.service.ResumeService;

@RestController
@RequestMapping("/user")
@Api(tags = {"유저 Controller"})
@Transactional
public class UserController {

	@Autowired
	private ResumeService resumeService;
	
	/**
	 * 회원정보수정 result 1-성공, result 0-실패
	 */
	@ApiOperation(value = "유저회원 정보 수정")
	@PostMapping("/updateUser")
	public int updateUser(@ApiParam("수정될 유저정보")Users user) throws NotFoundException{
		int result = resumeService.updateUser(user);
		
		return result;
	}
	
	/**
	 * 회원비밀번호 변경 result 1-성공, result 0-실패
	 */
	@ApiOperation(value = "유저 비밀번호 변경")
	@PostMapping("/updatePwd")
	public int updatePwd(@ApiParam("비밀번호가 변경될 유저정보")Users user) throws IOException, NotFoundException{
		int result = resumeService.updatePwd(user);
		
		return result;
	}
	
	/**
	 * 회원 탈퇴 result 1-성공, result 0-실패
	 */
	@ApiOperation(value = "유저 회원탈퇴")
	@PostMapping("/deleteUser")
	public int deleteUser(Users user) throws IOException{
		int result = resumeService.deleteUser(user);
		
		return result;
	}
	
	/**
	 * 예외 처리
	 */
	@ExceptionHandler(NotFoundException.class)
	public String notFoundError(Exception e) {
		
		return e.getMessage();
	}
	
	/**
	 * 예외 처리
	 */
	@ExceptionHandler(IOException.class)
	public String ioError(Exception e) {
		
		return e.getMessage();
	}
	
}