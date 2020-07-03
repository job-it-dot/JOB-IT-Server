package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import kosta.mvc.domain.Career;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Edu;
import kosta.mvc.domain.Lang;
import kosta.mvc.domain.LangClass;
import kosta.mvc.domain.LangLevel;
import kosta.mvc.domain.LangLicense;
import kosta.mvc.domain.License;
import kosta.mvc.domain.Link;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Project;
import kosta.mvc.domain.Resume;
import kosta.mvc.domain.UserSkill;
import kosta.mvc.domain.Users;

public interface ResumeService {
	
	/**
	 * 회원가입 result 1-성공, result 0-실패 
	 */
	int insertUser(Users user) throws IOException;
	
	/**
	 * 회원정보수정 result 1-성공, result 0-실패
	 */
	int updateUser(Users user) throws NotFoundException;
	
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
	 * 이력서 등록 학력
	 */
	int insertEdu(Resume resume) throws IOException;
	
	/**
	 * 이력서 등록 커리어
	 */
	int insertCareer(Resume resume) throws IOException;
	
	/**
	 * 이력서 등록 커리어-프로젝트
	 */
	int insertProject(Career career) throws IOException;
	
	/**
	 * 이력서 등록 자격증
	 */
	int insertLicense(Resume resume) throws IOException;
	
	/**
	 * 이력서 등록 언어
	 */
	int insertLang(Resume resume) throws IOException;
	
	/**
	 * 이력서 등록 언어-클래스
	 */
	int insertClass(Lang lang) throws IOException;
	
	/**
	 * 이력서 등록 언어-레벨
	 */
	int insertLevel(Lang lang) throws IOException;
	
	/**
	 * 이력서 등록 언어-라이센스
	 */
	int insertLangLicense(Lang lang) throws IOException;
	
	/**
	 * 이력서 등록 유저스킬
	 */
	int insertUserSkill(Resume resume) throws IOException;
	
	/**
	 * 이력서 등록 링크 
	 */
	int insertLink(Resume resume) throws IOException;
	
	/**
	 * 이력서 수정 result 1-성공, result 0-실패
	 */
	int updateResume(Resume resume) throws NotFoundException;
	
	/**
	 * 이력서 수정 학력
	 */
	int updateEdu(Edu edu) throws NotFoundException;
	
	/**
	 * 이력서 수정 커리어
	 */
	int updateCareer(Career career) throws NotFoundException;
	
	/**
	 * 이력서 수정 커리어-프로젝트
	 */
	int updateProject(Project project) throws NotFoundException;
	
	/**
	 * 이력서 수정 자격증
	 */
	int updateLicense(License license) throws NotFoundException;
	
	/**
	 * 이력서 수정 언어
	 */
	int updateLang(Lang lang) throws NotFoundException;
	
	/**
	 * 이력서 수정 언어 클래스
	 */
	int updateLangClass(LangClass langClass) throws NotFoundException;
	
	/**
	 * 이력서 수정 언어 레벨
	 */
	int updateLangLevel(LangLevel langLevel) throws NotFoundException;
	
	/**
	 * 이력서 수정 언어 자격증
	 */
	int updateLangLicense(LangLicense langLicense) throws NotFoundException;
	
	/**
	 * 이력서 수정 유저스킬
	 */
	int updateUserSkill(UserSkill userSkill) throws NotFoundException;
	
	/**
	 * 이력서 수정 링크
	 */
	int updateLink(Link link) throws NotFoundException;
	
	/**
	 * 이력서 삭제 result 1-성공, result 0-실패
	 */
	int deleteResume(Long resumeId) throws IOException, NotFoundException;
	
	/**
	 * 이력서 상세보기
	 */
	Resume resumeDetail(Resume resume) throws IOException, NotFoundException;
	
	/**
	 * 이력서 목록보기
	 */
	List<Resume> resumeList(Users user) throws IOException, NotFoundException;
	
	/**
	 * 이력서 온/오프 result 1-온, result 0-오프
	 */
	int resumeOnOff(Resume resume) throws IOException, NotFoundException;
	
	/**
	 * 오픈이력서 조회기업목록
	 */
	List<Companys> readCompany(Users user) throws IOException, NotFoundException;

}