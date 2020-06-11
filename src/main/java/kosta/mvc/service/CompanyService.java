package kosta.mvc.service;

import java.util.List;

import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Product;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.RecruitPlan;
import kosta.mvc.domain.Resume;

public interface CompanyService {
	
	/**
	 * 기업 정보 조회
	 */
	Companys selectCompanyById(int memberId);
	
	/**
	 * 기업정보 수정
	 * @return '0'은 수정실패 / '0'이 아니면 수정성공
	 */
	int update(Companys company);
	
	/**
	 * 기업 채용공고 목록 조회
	 */
	List<Recruit> selectRecruitByCompanyId(int memberId);
	
	/**
	 * 기업 채용공고 상세보기
	 */
	Recruit selectRecruitById(int recruitId);
	
	/**
	 * 기업 채용공고 등록
	 */
	int insertRecruit(Recruit recruit);
	
	/**
	 * 기업 채용공고 수정
	 */
	int updateRecruit(Recruit recruit);
	
	/**
	 * 기업 채용공고 삭제
	 */
	int deleteRecruit(int memberId, int recruitId);
	
	/**
	 * 예상 채용일정 목록 조회
	 */
	List<RecruitPlan> selectRecruitPlanByCompanyId(int memberId);
	
	/**
	 * 예상 채용일정 상세보기
	 */
	RecruitPlan selectRecruitPlanById(int recruitPlanId);
	
	/**
	 * 예상 채용일정 등록
	 */
	int insertRecruitPlan(RecruitPlan recruitPlan);
	
	/**
	 * 예상 채용일정 수정
	 */
	int updateRecruitPlan(RecruitPlan recruitPlan);	
	
	/**
	 * 예상 채용일정 삭제
	 */
	int deleteRecruitPlan(int memberId, int recruitPlanId);
	
	/**
	 * 해당 공고의 지원자 관리
	 */
	List<Apply> selectApplyByRecruitId(int recruitId);
	
	/**
	 * 웹 최상단 공고 노출 패키지 구매
	 */
	int insertPerchase(int memberId, Product product);
	
	/**
	 * 패키지 환불
	 */
	int updatePerchase(int perchaseId);
	
	/**
	 * 오픈 이력서 목록 조회
	 * : resume 테이블의 resume_open이 1이면 열람가능, 2이면 열람불가능
	 */
	List<Resume> selectOpenResumeAll();
	
	/**
	 * 오픈 이력서 상세보기(열람)
	 */
	Resume selectOenResumeByResumeId(int resumeId);
}
