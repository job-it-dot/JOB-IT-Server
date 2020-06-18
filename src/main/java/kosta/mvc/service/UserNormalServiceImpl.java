package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Resume;
import kosta.mvc.domain.Users;
import kosta.mvc.repository.LinkRepository;
import kosta.mvc.repository.MembersRepository;
import kosta.mvc.repository.ResumeRepository;
import kosta.mvc.repository.UsersRepository;

@Service
public class UserNormalServiceImpl implements UserNormalService {

	@Autowired
	private UsersRepository UsersRepository;
	
	@Autowired
	private MembersRepository MembersRepository;
	
	@Autowired
	private ResumeRepository ResumeRepository;
	
	@Autowired
	private LinkRepository LinkRepository;
	
	/**
	 * 회원가입 result 1-성공, result 0-실패 
	 */
	@Override
	public int insertUser(Users user) {
		Users dbUsers = UsersRepository.save(user);
		MembersRepository.save(user.getMember());
		int result;
		
		if(dbUsers==null) {
			result=0;
		}else {
			result=1;
		}
		
		return result;
		
	}

	/**
	 * 회원정보수정
	 */
	@Override
	public int updateUser(Users user) {
		Users dbuser = UsersRepository.findById(user.getUserId()).orElse(null);
		int result;
		if(dbuser==null) {
			result=0;
		}else {
			dbuser.setUserName(user.getUserName());
			dbuser.setUserPhone(user.getUserPhone());
			dbuser.setMember(user.getMember());
			result=1;
		}
		return result;
		
	}
	
	/**
	 * 회원비밀번호 변경
	 */
	@Override
	public int updatePwd(Users user) {
		Users dbuser = UsersRepository.findById(user.getUserId()).orElse(null); 
		int result;
		
		if(dbuser==null) {
			result=0;
		} 
		
		if(!dbuser.getMember().getMemberPassword().equals(user.getMember().getMemberPassword())){
			result=0;
		}else {
			dbuser.getMember().setMemberPassword(user.getMember().getMemberPassword());
			result=1;
		}
				
		return result;
		
	}

	/**
	 * 회원탈퇴
	 */
	@Override
	public int deleteUser(Users user) {
		Users dbuser = UsersRepository.findById(user.getUserId()).orElse(null);
		int result;
		
		if(dbuser==null) {
			result=0;
		}else {
			dbuser.getMember().setMemberStatus(3);
			result=1;
		}
		return result;
	}

	/**
	 * 이력서등록
	 */
	@Override
	public int insertResume(Resume resume) {
		
		return 0;
	}

	/**
	 * 이력서수정
	 */
	@Override
	public int updateResume(Resume resume) {
		
		return 0;
	}

	/**
	 * 이력서삭제
	 */
	@Override
	public int delete(int resumeId) {
		
		return 0;
	}

	/**
	 * 이력서 상세보기
	 */
	@Override
	public Resume resumeDetail(int resumeId) {
		
		return null;
	}

	/**
	 * 이력서 목록보기
	 */
	@Override
	public List<Resume> recruitList(int memberId) {
		
		return null;
	}

	/**
	 * 이력서 온/오프
	 */
	@Override
	public int resumeOnOff(int resumeOpen) {
		
		return 0;
	}

	/**
	 * 오픈이력서 조회기업목록
	 */
	@Override
	public List<Companys> readCompany(boolean isNew) {
		
		return null;
	}

}
