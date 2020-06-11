package kosta.mvc.service;

import java.util.List;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Resume;

public interface UserNormalService {
	
	/**
	 * 회원가입
	 */
	int insertUser(Members member);
	
	/**
	 * 회원정보수정
	 */
	int updateUser(Members member);
	
	/**
	 * 회원비밀번호 변경
	 */
	int updatePwd(Members member);
	
	/**
	 * 회원 탈퇴
	 */
	int deleteUser(int memberId);
	
	/**
	 * 이력서 등록
	 */
	int insertResume(Resume resume); 
	
	/**
	 * 이력서 수정
	 */
	int updateResume(Resume resume);
	
	/**
	 * 이력서 삭제
	 */
	int delete(int resumeId);
	
	/**
	 * 이력서 상세보기
	 */
	Resume resumeDetail(int resumeId);
	
	/**
	 * 이력서 목록보기
	 */
	List<Resume> recruitList();
	
	/**
	 * 이력서 온/오프
	 */
	int resumeOnOff(int resumeOpen);
	
	/**
	 * 오픈이력서 조회기업목록
	 */
	List<Companys> readCompany(boolean isNew);

}
