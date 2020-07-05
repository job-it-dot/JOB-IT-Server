package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.DTO.CompanysDTO;
import kosta.mvc.DTO.PerchaseDTO;
import kosta.mvc.DTO.RecruitDTO;
import kosta.mvc.DTO.RecruitPlanDTO;
import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.RecruitPlan;
import kosta.mvc.domain.Resume;
import kosta.mvc.service.CompanyService;

@RestController
@Api(tags = {"기업 컨트롤러"})
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

//	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@ApiOperation(value = "기업 정보 조회", notes = "return : 기업회원 정보")
	@PostMapping("/info")
	public Companys info(@ApiParam("기업id") @RequestBody Long companyId) throws IOException, NotFoundException {
		return companyService.selectCompanyById(companyId);
	}
	
	@ApiOperation(value = "비밀번호 확인", notes = "return : 0-비밀번호 불일치 / 1-일치")
	@PostMapping("/checkPwd")
	public int checkPwd(@ApiParam("회원id") @RequestBody Long memberId, @ApiParam("입력받은 비밀번호") @RequestBody String password) throws IOException, NotFoundException{
		int result = 0;

		Members member = (Members)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(passwordEncoder.matches(password, member.getMemberPassword())) result = 1;
		
		return result;
	}
	
	@ApiOperation(value = "기업정보(회원정보) 수정", notes = "return : 0-수정실패 / 1-성공")
	@PostMapping("/updateInfo")
	public int updateInfo(@ApiParam("수정할 기업 정보") @RequestBody CompanysDTO companyDTO) throws IOException, NotFoundException {
		Companys company = new Companys(companyDTO);
		int result = companyService.updateCompany(company);
		
		if(result == 1 && company.getMember().getMemberPassword() != null) {	//수정이 제대로 이루어지고, 비밀번호를 수정한 경우
			//회원정보 수정위해 Spring Security 세션 회원정보를 반환받는다
			Members member = (Members)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			//변경할 비밀번호를 암호화한다 
			String encodePassword=passwordEncoder.encode(company.getMember().getMemberPassword());
			
			// 수정한 회원정보로 Spring Security 세션 회원정보를 업데이트한다
			member.setMemberPassword(encodePassword);
		}
		
		return result;
	}
	
//	@ApiOperation(value = "로그인한 기업회원이 올린 채용공고 목록 조회", notes = "return : 공고 list")
//	@PostMapping("/recruitList")
//	public List<Recruit> recruitList() throws IOException, NotFoundException {
//		Members member = (Members)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Long companyId = companyService.getCompanyId(member.getMemberId());
//		return companyService.selectRecruitByCompanyId(companyId);
//	}
	
	@ApiOperation(value = "채용공고 상세보기", notes = "return : 채용공고내용")
	@GetMapping("/recruit/{recruitId}")
	public Recruit recruitInfo(@ApiParam("링크로 넘어오는 채용공고 아이디")@PathVariable String recruitId) throws IOException, NotFoundException {
		return companyService.selectRecruitById(Long.parseLong(recruitId));
	}
	
	@ApiOperation(value = "채용공고 등록", notes = "return : 0-등록실패 / 1-등록성공")
	@PostMapping("/uploadRecruit")
	public int uploadRecruit(@ApiParam("등록할 채용공고 정보") @RequestBody RecruitDTO recruitDTO) throws IOException {
		Recruit recruit = new Recruit(recruitDTO);
		return companyService.insertRecruit(recruit);
	}
	
	@ApiOperation(value = "채용공고 수정", notes = "return : 0-수정실패 / 1-성공")
	@PostMapping("/updateRecruit")
	public int updateRecruit(@ApiParam("수정할 채용공고 정보") @RequestBody RecruitDTO recruitDTO) throws IOException, NotFoundException {
		Recruit recruit = new Recruit(recruitDTO);
		return companyService.updateRecruit(recruit);
	}
	
	@ApiOperation(value = "채용공고 내리기", notes = "return : 0-내리기 실패 / 1-성공")
	@GetMapping("/unpostRecruit/{recruitId}")
	public int unpostRecruit(@ApiParam("내릴 채용공고의 아이디")@PathVariable String recruitId) throws IOException, NotFoundException {
		return companyService.unpostRecruit(Long.parseLong(recruitId));
	}
	
//	@ApiOperation(value = "예상 채용일정 목록 조회", notes = "return : 예상 채용일정 list")
//	@PostMapping("/recruitPlanList")
//	public List<RecruitPlan> recruitPlanList() throws IOException, NotFoundException {
//		Members member = (Members)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Long companyId = companyService.getCompanyId(member.getMemberId());
//		return companyService.selectRecruitPlanByCompanyId(companyId);
//	}
	
	@ApiOperation(value = "예상 채용일정 상세보기", notes = "return : 예상 채용일정 내용")
	@GetMapping("/recruitPlan/{recruitPlanId}")
	public RecruitPlan recruitPlanInfo(@ApiParam("링크로 넘어오는 예상 채용일정 아이디")@PathVariable String recruitPlanId) throws IOException, NotFoundException {
		return companyService.selectRecruitPlanById(Long.parseLong(recruitPlanId));
	}
	
	@ApiOperation(value = "예상 채용일정 등록", notes = "return : 0-등록실패 / 1-등록성공")
	@PostMapping("/uploadRecruitPlan")
	public int uploadRecruitPlan(@ApiParam("등록할 예상 채용일정 정보") @RequestBody RecruitPlanDTO recruitPlanDTO) throws IOException {
		RecruitPlan recruitPlan = new RecruitPlan(recruitPlanDTO);
		return companyService.insertRecruitPlan(recruitPlan);
	}
	
	@ApiOperation(value = "예상 채용일정 수정", notes = "return : 0-수정실패 / 1-성공")
	@PostMapping("/updateRecruitPlan")
	public int updateRecruitPlan(@ApiParam("수정할 예상 채용일정 정보") @RequestBody RecruitPlanDTO recruitPlanDTO) throws IOException, NotFoundException {
		RecruitPlan recruitPlan = new RecruitPlan(recruitPlanDTO);
		return companyService.updateRecruitPlan(recruitPlan);
	}
	
//	@ApiOperation(value = "예상 채용일정 삭제", notes = "return : 0-삭제실패 / 1-성공")
//	@GetMapping("/deleteRecruitPlan/{recruitPlanId}")
//	public int deleteRecruitPlan(@ApiParam("삭제할 예상 채용일정 아이디")@PathVariable String recruitPlanId) throws IOException, NotFoundException {
//		Members member = (Members)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Long companyId = companyService.getCompanyId(member.getMemberId());
//		return companyService.deleteRecruitPlan(companyId, Long.parseLong(recruitPlanId));
//	}
	
	@ApiOperation(value = "한 공고의 지원 리스트", notes = "return : 지원(Apply table)의 list")
	@GetMapping("/applyList/{recruitId}")
	public List<Apply> applyList(@ApiParam("지원자를 확인하고 싶은 채용공고의 아이디")@PathVariable String recruitId) throws IOException {
		return companyService.selectApplyByRecruitId(Long.parseLong(recruitId));
	}
	
	@ApiOperation(value = "한 공고의 지원 상세보기", notes = "return : 지원(Apply table)의 정보")
	@GetMapping("/apply/{applyId}")
	public Apply applyInfo(@ApiParam("확인할 지원아이디")@PathVariable String applyId) throws IOException, NotFoundException {
		return companyService.selectApplyById(Long.parseLong(applyId));
	}
	
	@ApiOperation(value = "웹 최상단 공고 노출 패키지 구매", notes = "return : 0-구매실패 / 1-성공")
	@PostMapping("/perchase")
	public int perchase(@ApiParam("구매 정보") @RequestBody PerchaseDTO perchaseDTO) throws IOException {
		Perchase perchase = new Perchase(perchaseDTO);
		return companyService.insertPerchase(perchase);
	}
	
	@ApiOperation(value = "패키지 환불신청", notes = "return : 0-신청실패 / 1-성공")
	@GetMapping("/refund/{perchaseId}")
	public int refund(@ApiParam("환불신청할 구매내역의 아이디")@PathVariable String perchaseId) throws IOException, NotFoundException, RuntimeException {
		return companyService.updatePerchase(Long.parseLong(perchaseId));
	}
	
//	@ApiOperation(value = "오픈 이력서 목록 조회", notes = "return : 오픈 이력서 list")
//	@PostMapping("/openResume")
//	public List<Resume> openResume() throws IOException, NotFoundException, RuntimeException {
//		Members member = (Members)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Long companyId = companyService.getCompanyId(member.getMemberId());
//		return companyService.selectOpenResumeAll(companyId);
//	}
	
//	@ApiOperation(value = "오픈 이력서 상세보기", notes = "return : 오픈 이력서 내용")
//	@GetMapping("/openResume/{resumeId}")
//	public Resume openResumeInfo(@ApiParam("링크로 넘어오는 예상 채용일정 아이디")@PathVariable String resumeId) throws IOException, NotFoundException {
//		Members member = (Members)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Long companyId = companyService.getCompanyId(member.getMemberId());
//		return companyService.selectOpenResumeByResumeId(companyId, Long.parseLong(resumeId));
//	}
	
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
	
	@ExceptionHandler(NotFoundException.class)
	@ApiOperation("에러메시지 출력 메소드")
	public String notFoundError(@ApiParam("오류파라미터") Exception e) {
		return e.getMessage();
	}
}
