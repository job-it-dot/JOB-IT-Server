package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Resume;
import kosta.mvc.domain.Users;

public interface UserNormalService {
	
	/**
	 * 회원가입 result 1-성공, result 0-실패 
	 */
	int insertUser(Users user) throws IOException;
	
	/**
	 * 회원정보수정 result 1-성공, result 0-실패
	 */
	int updateUser(Users user) throws IOException, NotFoundException;
	
	/**
	 * 회원비밀번호 변경 result 1-성공, result 0-실패
	 */
	int updatePwd(Users user) throws IOException, NotFoundException;
	
	/**
	 * 회원 탈퇴 result 1-성공, result 0-실패
	 */
	int deleteUser(Users user) throws IOException;
	
	/**
	 * 이력서 등록 result 1-성공, result 0-실패
	 */
	int insertResume(Resume resume) throws IOException; 
	
	/**
	 * 이력서 수정 result 1-성공, result 0-실패
	 */
	int updateResume(Resume resume) throws IOException, NotFoundException;
	
	/**
	 * 이력서 삭제 result 1-성공, result 0-실패
	 */
	int delete(int resumeId) throws IOException, NotFoundException;
	
	/**
	 * 이력서 상세보기
	 */
	Resume resumeDetail(int resumeId) throws IOException, NotFoundException;
	
	/**
	 * 이력서 목록보기
	 */
	List<Resume> recruitList(int memberId) throws IOException, NotFoundException;
	
	/**
	 * 이력서 온/오프 result 1-온, result 0-오프
	 */
	int resumeOnOff(int resumeOpen) throws IOException, NotFoundException;
	
	/**
	 * 오픈이력서 조회기업목록
	 */
	List<Companys> readCompany(boolean isNew) throws IOException, NotFoundException;

}
