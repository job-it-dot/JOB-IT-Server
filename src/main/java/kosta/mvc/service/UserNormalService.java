package kosta.mvc.service;

import java.util.List;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Resume;

public interface UserNormalService {
	
	/**
	 * 회원가입 result 1-성공, result 0-실패 
	 */
	int insertUser(Members member);
	
	/**
	 * 회원정보수정 result 1-성공, result 0-실패
	 */
	int updateUser(Members member);
	
	/**
	 * 회원비밀번호 변경 result 1-성공, result 0-실패
	 */
	int updatePwd(Members member);
	
	/**
	 * 회원 탈퇴 result 1-성공, result 0-실패
	 */
	int deleteUser(Members member);
	
	/**
	 * 이력서 등록 result 1-성공, result 0-실패
	 */
	int insertResume(Resume resume); 
	
	/**
	 * 이력서 수정 result 1-성공, result 0-실패
	 */
	int updateResume(Resume resume);
	
	/**
	 * 이력서 삭제 result 1-성공, result 0-실패
	 */
	int delete(int resumeId);
	
	/**
	 * 이력서 상세보기
	 */
	Resume resumeDetail(int resumeId);
	
	/**
	 * 이력서 목록보기
	 */
	List<Resume> recruitList(int memberId);
	
	/**
	 * 이력서 온/오프 result 1-온, result 0-오프
	 */
	int resumeOnOff(int resumeOpen);
	
	/**
	 * 오픈이력서 조회기업목록
	 */
	List<Companys> readCompany(boolean isNew);

}
