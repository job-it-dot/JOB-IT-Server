package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javassist.NotFoundException;
import kosta.mvc.DTO.CompanysDTO;
import kosta.mvc.DTO.MembersDTO;
import kosta.mvc.DTO.UsersDTO;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.RecruitForm;
import kosta.mvc.domain.Users;
import kosta.mvc.service.CompanyService;
import kosta.mvc.service.PublicService;
import kosta.mvc.service.RecruitService;
import kosta.mvc.service.ResumeService;

@RestController
@Api(tags = {"PublicMethod. 로그인 불필요."})
@RequestMapping("/guest")
public class PublicController {
	
	@Autowired
	private PublicService publicService;
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	private RecruitService recruitService;

	@Autowired
	private ResumeService resumeService;
	
	
	/**
	 * 회원가입 result 1-성공, result 0-실패 
	 */
	@ApiOperation(value = "유저회원가입")
	@PostMapping("/insertUser")
	public int insertUser(@ApiParam("회원가입할 유저 정보") @RequestBody UsersDTO userDTO) throws IOException{
		
		System.out.println(123);
		Users user = new Users(userDTO);
		int result = resumeService.insertUser(user);
		
		return result;
	}
	
	@ApiOperation(value = "이메일 중복체크", notes = "return : 0-중복아님 / 1-중복")
	@PostMapping("/idDuplicate")
	public int idDuplicate(@ApiParam("가입할 이메일") @RequestBody String memberEmail) throws IOException {
		return companyService.duplicateEmail(memberEmail);
	}
	
	@ApiOperation(value = "기업 회원가입", notes = "return : 0-가입실패 / 1-가입성공")
	@PostMapping("/join")
	public int join(@ApiParam("기업 가입 정보") @RequestBody CompanysDTO companyDTO) throws IOException {
		Companys company = new Companys(companyDTO);
		if(companyService.duplicateEmail(company.getMember().getMemberEmail()) == 1) {
			throw new RuntimeException("이미 사용중인 이메일 입니다.");
		}
		return companyService.insertCompany(company);
	}
	
	@PostMapping("/search")
	@ApiOperation("채용공고 검색 Method. Integer의 경우 null, String의경우 null혹은 empty이면 조건에서 제외됨")
	public List<Recruit> searchRecruit(
			@RequestBody @ApiParam("입력받은 String을 포함한 회사명")String companyName, 
			@RequestBody @ApiParam("요구경력 년수가 입력받은 integer 이하")Integer career, 
			@RequestBody @ApiParam("입력받은 String을 포함한 근무지 주소")String addr, 
			@RequestBody @ApiParam("요구학력단계(RequiredEdu.reqEduGrade)가 입력된 integer이하")Integer edu,
			@RequestBody @ApiParam("select-box로 선택된 회사type이 일치")String companyType, 
			@RequestBody @ApiParam("예상 급여(연봉)가 integer 이상")Integer salary, 
			@RequestBody @ApiParam("select-box로 선택된 position명이 일치")String position){
		
		return publicService.searchRecruit(companyName, career, addr, edu, companyType, salary, position);
		
	}
	
	
	@GetMapping("/selectAll")
	@ApiOperation("채용정보 목록보기")
	public List<RecruitForm> selectAllRecruit() {
		List<RecruitForm> list = recruitService.selectAllRecruitInfoList();
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
	
	@PostMapping("/readRecruit/{recruitFormId}")
	@ApiOperation("채용정보 상세보기")
	public RecruitForm readRecruit(@ApiParam("각 채용공고id") @PathVariable String recruitFormId) throws NotFoundException {
		Long recruitFormIdL = Long.parseLong(recruitFormId);
		RecruitForm recruit = recruitService.selectRecruitById(recruitFormIdL);
		return recruit;
	}
}
