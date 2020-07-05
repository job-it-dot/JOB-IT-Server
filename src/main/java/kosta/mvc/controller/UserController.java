package kosta.mvc.controller;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.DTO.UsersDTO;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Users;
import kosta.mvc.service.ResumeService;
import kosta.mvc.service.UserService;

@RestController
@RequestMapping("/user")
@Api(tags = {"유저 Controller"})
@Transactional
public class UserController {

	@Autowired
	private ResumeService resumeService;
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "회원정보 조회", notes = "return : 일반회원(Users)의 정보")
	@PostMapping("/info")
	public Users userInfo() throws IOException, NotFoundException {
		Members member = (Members)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return userService.selectUserByMemberId(member.getMemberId());
	}
	
	/**
	 * 회원정보수정 result 1-성공, result 0-실패
	 */
	@ApiOperation(value = "유저회원 정보 수정")
	@PostMapping("/updateUser")
	public int updateUser(@ApiParam("수정될 유저정보") @RequestBody UsersDTO userDTO) throws NotFoundException{
		Users user = new Users(userDTO);
		int result = resumeService.updateUser(user);
		
		return result;
	}
	
	/**
	 * 회원비밀번호 변경 result 1-성공, result 0-실패
	 */
	@ApiOperation(value = "유저 비밀번호 변경")
	@PostMapping("/updatePwd")
	public int updatePwd(@ApiParam("비밀번호가 변경될 유저정보") @RequestBody UsersDTO userDTO) throws IOException, NotFoundException{
		Users user = new Users(userDTO);
		int result = resumeService.updatePwd(user);
		
		return result;
	}
	
	/**
	 * 회원 탈퇴 result 1-성공, result 0-실패
	 */
	@ApiOperation(value = "유저 회원탈퇴")
	@PostMapping("/deleteUser")
	public int deleteUser(@RequestBody UsersDTO userDTO) throws IOException{
		Users user = new Users(userDTO);
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
