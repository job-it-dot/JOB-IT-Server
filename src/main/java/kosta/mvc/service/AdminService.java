package kosta.mvc.service;



import java.util.List;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Users;

public interface AdminService {
	
	/**
	 * 유저회원 조회
	 */
	List<Users> selectUser();
	
	/**
	 * 기업회원 조회
	 */
	List<Companys> selectCompany();
	
	/**
	 * 기업 강제탈퇴
	 */
	int companysWithdrawal(int companyId);
	
	/**
	 * 유저 강제탈퇴
	 */
	int memberWithdrawal(int memberId);
	
	/**
	 * 기업회원 가입 승인
	 */
	int companyApproval(int companyId);
	
	/**
	 * 매출통계 조회
	 */
	List<Perchase> salesSelect();
	
	/**
	 * 환불 처리
	 * 구매내역 테이블에 상태값을 변경해주고 기업 테이블에 잔여 캐시 포인트  트렌젝션 처리
	 */
	int Refund(int perchaseId);
	

}
