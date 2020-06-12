package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

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
	Companys selectCompanyById(int memberId) throws IOException;
	
	/**
	 * 기업정보 수정
	 * @return '0'은 수정실패 / '0'이 아니면 수정성공
	 */
	int update(Companys company) throws IOException, NotFoundException;
	
	/**
	 * 기업 채용공고 목록 조회
	 */
	List<Recruit> selectRecruitByCompanyId(int memberId) throws IOException;
	
	/**
	 * 기업 채용공고 상세보기
	 */
	Recruit selectRecruitById(int recruitId) throws IOException, NotFoundException;
	
	/**
	 * 기업 채용공고 등록
	 */
	int insertRecruit(Recruit recruit) throws IOException;
	
	/**
	 * 기업 채용공고 수정
	 */
	int updateRecruit(Recruit recruit) throws IOException, NotFoundException;
	
	/**
	 * 기업 채용공고 삭제
	 */
	int deleteRecruit(int memberId, int recruitId) throws IOException;
	
	/**
	 * 예상 채용일정 목록 조회
	 */
	List<RecruitPlan> selectRecruitPlanByCompanyId(int memberId) throws IOException;
	
	/**
	 * 예상 채용일정 상세보기
	 */
	RecruitPlan selectRecruitPlanById(int recruitPlanId) throws IOException, NotFoundException;
	
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
	int deleteRecruitPlan(int memberId, int recruitPlanId) throws IOException, NotFoundException;
	
	/**
	 * 해당 공고의 지원 리스트
	 */
	List<Apply> selectApplyByRecruitId(int recruitId) throws IOException;
	
	/**
	 * 해당 공고의 지원 상세보기
	 */
	Apply selectApplyById(int applyId) throws IOException, NotFoundException;
	
	/**
	 * 웹 최상단 공고 노출 패키지 구매
	 */
	int insertPerchase(int memberId, Product product) throws IOException;
	
	/**
	 * 패키지 환불 - 구매내역의 status만 바꿔준다.
	 * perchase_status 2번이 기업이 환불신청을 한 상태
	 */
	int updatePerchase(int perchaseId) throws IOException, NotFoundException;
	
	/**
	 * 오픈 이력서 목록 조회
	 * : resume 테이블의 resume_open이 1이면 열람가능, 2이면 열람불가능
	 */
	List<Resume> selectOpenResumeAll() throws IOException;
	
	/**
	 * 오픈 이력서 상세보기(열람)
	 */
	Resume selectOenResumeByResumeId(int resumeId) throws IOException, NotFoundException;
}
