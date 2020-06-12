package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Users;

public interface AdminService {
	/**
	 * 유저회원 조회
	 */
	List<Users> selectUser() throws IOException;
	
	/**
	 * 유저회원 id로검색
	 */
	Users selectById(long userId) throws IOException;
	
	/**
	 * 기업회원 조회
	 */
	List<Companys> selectCompany() throws IOException;
	
	/**
	 * 기업회원 id로검색
	 */
	Companys selelctCompanyId(long CompanyId) throws IOException;
	
	
	/**
	 * 기업 강제탈퇴
	 */
	int companysWithdrawal(long companyId) throws NotFoundException, IOException;
	
	
	/**
	 * 유저 강제탈퇴
	 */
	int memberWithdrawal(long memberId) throws NotFoundException, IOException;
	
	/**
	 * 기업회원 가입 승인
	 */
	int companyApproval(long companyId) throws IOException;
	
	/**
	 * 매출통계 조회
	 */
	List<Perchase> salesSelect() throws IOException;
	
	/**
	 * 환불 처리
	 * 구매내역 테이블에 상태값을 변경해주고 기업 테이블에 잔여 캐시 포인트  트렌젝션 처리
	 * perchase_status 3번이 관리자가 환불승인을 해준상태
	 */
	int Refund(long perchaseId) throws RuntimeException, IOException;
	

}
