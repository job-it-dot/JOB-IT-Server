package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.RecruitPlan;
import kosta.mvc.domain.Resume;
import kosta.mvc.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	//////////////////모든 사람이 접속할 수 있는 컨트롤러로 옮겨야함
	
	@ApiOperation(value = "이메일 중복체크", notes = "return : 0-중복아님 / 1-중복")
	@RequestMapping("/idDuplicate")
	public int idDuplicate(@ApiParam("가입할 이메일")String memberEmail) throws IOException {
		return companyService.duplicateEmail(memberEmail);
	}
	
	@ApiOperation(value = "기업 회원가입", notes = "return : 0-가입실패 / 1-가입성공")
	@RequestMapping("/join")
	public int join(@ApiParam("기업 가입 정보")Companys company) throws IOException {
		if(companyService.duplicateEmail(company.getMember().getMemberEmail()) == 1) {
			throw new RuntimeException("이미 사용중인 이메일 입니다.");
		}
		return companyService.insertCompany(company);
	}
	
	///////////////////
	
	@ApiOperation(value = "기업 정보 조회", notes = "return : 기업회원 정보")
	@RequestMapping("/info")
	public Companys info(HttpSession session) throws IOException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.selectCompanyById(companyId);
	}
	
	@ApiOperation(value = "비밀번호 확인", notes = "return : 0-비밀번호 불일치 / 1-일치")
	@RequestMapping("/checkPwd")
	public int checkPwd(HttpSession session, @ApiParam("입력받은 비밀번호")String password) throws IOException, NotFoundException{
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.checkPassword(companyId, password);
	}
	
	@ApiOperation(value = "기업정보(회원정보) 수정", notes = "return : 0-수정실패 / 1-성공")
	@RequestMapping("/updateInfo")
	public int updateInfo(@ApiParam("수정할 기업 정보")Companys company) throws IOException, NotFoundException {
		return companyService.updateCompany(company);
	}
	
	@ApiOperation(value = "로그인한 기업회원이 올린 채용공고 목록 조회", notes = "return : 공고 list")
	@RequestMapping("/recruitList")
	public List<Recruit> recruitList(HttpSession session) throws IOException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.selectRecruitByCompanyId(companyId);
	}
	
	@ApiOperation(value = "채용공고 상세보기", notes = "return : 채용공고내용")
	@RequestMapping("/recruit/{recruitId}")
	public Recruit recruitInfo(@ApiParam("링크로 넘어오는 채용공고 아이디")@PathVariable Long recruitId) throws IOException, NotFoundException {
		return companyService.selectRecruitById(recruitId);
	}
	
	@ApiOperation(value = "채용공고 등록", notes = "return : 0-등록실패 / 1-등록성공")
	@RequestMapping("/uploadRecruit")
	public int uploadRecruit(@ApiParam("등록할 채용공고 정보")Recruit recruit) throws IOException {
		return companyService.insertRecruit(recruit);
	}
	
	@ApiOperation(value = "채용공고 수정", notes = "return : 0-수정실패 / 1-성공")
	@RequestMapping("/updateRecruit")
	public int updateRecruit(@ApiParam("수정할 채용공고 정보")Recruit recruit) throws IOException, NotFoundException {
		return companyService.updateRecruit(recruit);
	}
	
	@ApiOperation(value = "채용공고 내리기", notes = "return : 0-내리기 실패 / 1-성공")
	@RequestMapping("/unpostRecruit/{recruitId}")
	public int unpostRecruit(@ApiParam("내릴 채용공고의 아이디")@PathVariable Long recruitId) throws IOException, NotFoundException {
		return companyService.unpostRecruit(recruitId);
	}
	
	@ApiOperation(value = "예상 채용일정 목록 조회", notes = "return : 예상 채용일정 list")
	@RequestMapping("/recruitPlanList")
	public List<RecruitPlan> recruitPlanList(@ApiParam("로그인한 기업의 아이디")HttpSession session) throws IOException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.selectRecruitPlanByCompanyId(companyId);
	}
	
	@ApiOperation(value = "예상 채용일정 상세보기", notes = "return : 예상 채용일정 내용")
	@RequestMapping("/recruitPlan/{recruitPlanId}")
	public RecruitPlan recruitPlanInfo(@ApiParam("링크로 넘어오는 예상 채용일정 아이디")@PathVariable Long recruitPlanId) throws IOException, NotFoundException {
		return companyService.selectRecruitPlanById(recruitPlanId);
	}
	
	@ApiOperation(value = "예상 채용일정 등록", notes = "return : 0-등록실패 / 1-등록성공")
	@RequestMapping("/uploadRecruitPlan")
	public int uploadRecruitPlan(@ApiParam("등록할 예상 채용일정 정보")RecruitPlan recruitPlan) throws IOException {
		return companyService.insertRecruitPlan(recruitPlan);
	}
	
	@ApiOperation(value = "예상 채용일정 수정", notes = "return : 0-수정실패 / 1-성공")
	@RequestMapping("/updateRecruitPlan")
	public int updateRecruitPlan(@ApiParam("수정할 예상 채용일정 정보")RecruitPlan recruitPlan) throws IOException, NotFoundException {
		return companyService.updateRecruitPlan(recruitPlan);
	}
	
	@ApiOperation(value = "예상 채용일정 삭제", notes = "return : 0-삭제실패 / 1-성공")
	@RequestMapping("/deleteRecruitPlan/{recruitPlanId}")
	public int deleteRecruitPlan(@ApiParam("로그인한 기업회원의 아이디")HttpSession session, @ApiParam("삭제할 예상 채용일정 아이디")@PathVariable Long recruitPlanId) throws IOException, NotFoundException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.deleteRecruitPlan(companyId, recruitPlanId);
	}
	
	@ApiOperation(value = "한 공고의 지원 리스트", notes = "return : 지원(Apply table)의 list")
	@RequestMapping("/applyList/{recruitId}")
	public List<Apply> applyList(@ApiParam("지원자를 확인하고 싶은 채용공고의 아이디")@PathVariable Long recruitId) throws IOException {
		return companyService.selectApplyByRecruitId(recruitId);
	}
	
	@ApiOperation(value = "한 공고의 지원 상세보기", notes = "return : 지원(Apply table)의 정보")
	@RequestMapping("/apply/{applyId}")
	public Apply applyInfo(@ApiParam("확인할 지원아이디")@PathVariable Long applyId) throws IOException, NotFoundException {
		return companyService.selectApplyById(applyId);
	}
	
	@ApiOperation(value = "웹 최상단 공고 노출 패키지 구매", notes = "return : 0-구매실패 / 1-성공")
	@RequestMapping("/perchase")
	public int perchase(@ApiParam("구매 정보")Perchase perchase) throws IOException {
		return companyService.insertPerchase(perchase);
	}
	
	@ApiOperation(value = "패키지 환불신청", notes = "return : 0-신청실패 / 1-성공")
	@RequestMapping("/refund/{perchaseId}")
	public int refund(@ApiParam("환불신청할 구매내역의 아이디")@PathVariable Long perchaseId) throws IOException, NotFoundException, RuntimeException {
		return companyService.updatePerchase(perchaseId);
	}
	
	@ApiOperation(value = "오픈 이력서 목록 조회", notes = "return : 오픈 이력서 list")
	@RequestMapping("/openResume")
	public List<Resume> openResume(@ApiParam("로그인한 기업회원의 아이디")HttpSession session) throws IOException, RuntimeException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.selectOpenResumeAll(companyId);
	}
	
	@ApiOperation(value = "오픈 이력서 상세보기", notes = "return : 오픈 이력서 내용")
	@RequestMapping("/openResume/{resumeId}")
	public Resume openResumeInfo(@ApiParam("로그인한 기업회원의 아이디")HttpSession session, @ApiParam("링크로 넘어오는 예상 채용일정 아이디")@PathVariable Long resumeId) throws IOException, NotFoundException {
		Long companyId = Long.parseLong((String)session.getAttribute("companyId"));
		return companyService.selectOpenResumeByResumeId(companyId, resumeId);
	}
	
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
}
