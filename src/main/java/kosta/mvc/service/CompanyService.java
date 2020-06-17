package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.RecruitPlan;
import kosta.mvc.domain.Resume;

public interface CompanyService {
	
	/**
	 * 기업 정보 조회
	 */
	Companys selectCompanyById(Long companyId) throws IOException;
	
	/**
	 * 비밀번호 확인
	 * @return '0'은 비밀번호 불일치 / '1'이면 비밀번호 일치
	 */
	int checkPassword(Long companyId, String password) throws IOException, NotFoundException;
	
	/**
	 * 기업정보(회원정보) 수정 - 비밀번호 재확인 후 비밀번호가 같으면 수정
	 * @return '0'은 수정실패  / '1'이면 수정성공
	 */
	int updateCompany(Companys company) throws IOException, NotFoundException;
	
	/**
	 * 기업 채용공고 목록 조회
	 */
	List<Recruit> selectRecruitByCompanyId(Long companyId) throws IOException;
	
	/**
	 * 기업 채용공고 상세보기
	 */
	Recruit selectRecruitById(Long recruitId) throws IOException, NotFoundException;
	
	/**
	 * 기업 채용공고 등록
	 */
	int insertRecruit(Recruit recruit) throws IOException;
	
	/**
	 * 기업 채용공고 수정
	 */
	int updateRecruit(Recruit recruit) throws IOException, NotFoundException;
	
	/**
	 * 기업 채용공고 삭제 - 삭제 안하고 status 값 변경해서 글 안보이게 처리할 것 같음. 지원자 관리해야하니까
	 */
	int deleteRecruit(Long companyId, Long recruitId) throws IOException;
	
	/**
	 * 예상 채용일정 목록 조회
	 */
	List<RecruitPlan> selectRecruitPlanByCompanyId(Long companyId) throws IOException;
	
	/**
	 * 예상 채용일정 상세보기
	 */
	RecruitPlan selectRecruitPlanById(Long recruitPlanId) throws IOException, NotFoundException;
	
	/**
	 * 예상 채용일정 등록
	 */
	int insertRecruitPlan(RecruitPlan recruitPlan) throws IOException;
	
	/**
	 * 예상 채용일정 수정
	 */
	int updateRecruitPlan(RecruitPlan recruitPlan) throws IOException, NotFoundException;	
	
	/**
	 * 예상 채용일정 삭제
	 */
	int deleteRecruitPlan(Long companyId, Long recruitPlanId) throws IOException, NotFoundException;
	
	/**
	 * 해당 공고의 지원 리스트
	 */
	List<Apply> selectApplyByRecruitId(Long recruitId) throws IOException;
	
	/**
	 * 해당 공고의 지원 상세보기
	 */
	Apply selectApplyById(Long applyId) throws IOException, NotFoundException;
	
	/**
	 * 웹 최상단 공고 노출 패키지 구매
	 */
	int insertPerchase(Perchase perchase) throws IOException;
	
	/**
	 * 패키지 환불 - 구매내역의 status만 바꿔준다.
	 * perchase_status 2번이 기업이 환불신청을 한 상태
	 */
	int updatePerchase(Long perchaseId) throws IOException, NotFoundException;
	
	/**
	 * 오픈 이력서 목록 조회
	 * : resume 테이블의 resume_open이 1이면 열람가능, 2이면 열람불가능
	 */
	List<Resume> selectOpenResumeAll() throws IOException;
	
	/**
	 * 오픈 이력서 상세보기(열람)
	 */
	Resume selectOpenResumeByResumeId(Long resumeId) throws IOException, NotFoundException;
}
