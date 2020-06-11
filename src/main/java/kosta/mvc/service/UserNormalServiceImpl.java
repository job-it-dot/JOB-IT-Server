package kosta.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Resume;

@Service
public class UserNormalServiceImpl implements UserNormalService {

	
	/**
	 * 회원가입 result 1-성공, result 0-실패 
	 */
	@Override
	public int insertUser(Members member) {
		/*Members dbmember = repository.save(member);
		int result;
		
		if(dbmember==null) {
			result=0;
		}else {
			result=1;
		}
		
		return result;*/
		return 0;
	}

	/**
	 * 회원정보수정
	 */
	@Override
	public int updateUser(Members member) {
		/*Members dbmember = repository.save(member);
		int result;
		if(dbmember==null) {
			result=0;
		}else {
			result=1;
		}
		return result;*/
		return 0;
	}
	
	/**
	 * 회원비밀번호 변경
	 */
	@Override
	public int updatePwd(Members member) {
		/*Members dbmember = repository.findById(member.getMemberId()).orElse(null);
		int result;
		
		if(dbmember==null) {
			result=0;
		}else {
			result=1;
		}
				
		return result;*/
		return 0;
	}

	/**
	 * 회원탈퇴
	 */
	@Override
	public int deleteUser(int memberId) {
		
		return 0;
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
	public List<Resume> recruitList() {
		
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
