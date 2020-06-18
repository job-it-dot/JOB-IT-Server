package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Resume;
import kosta.mvc.domain.Users;
import kosta.mvc.repository.CareerRepository;
import kosta.mvc.repository.EduRepository;
import kosta.mvc.repository.LangRepository;
import kosta.mvc.repository.LicenseRepository;
import kosta.mvc.repository.LinkRepository;
import kosta.mvc.repository.MembersRepository;
import kosta.mvc.repository.ResumeRepository;
import kosta.mvc.repository.UserSkillRepository;
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
	
	@Autowired
	private EduRepository EduRepository;
	
	@Autowired
	private CareerRepository CareerRepository;
	
	@Autowired
	private LicenseRepository LicenseRepository;
	
	@Autowired
	private LangRepository LangRepository;
	
	@Autowired
	private UserSkillRepository UserSkillRepository;
	
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
		
		int result;
		
		if(resume==null) {
			result=0;
		}else {
			ResumeRepository.save(resume);
			EduRepository.saveAll(resume.getEdus());
			CareerRepository.saveAll(resume.getCareers());
			//project
			LicenseRepository.saveAll(resume.getLicenses());
			LangRepository.saveAll(resume.getLangs());
			//lang_class, lang_level, lang_license
			UserSkillRepository.saveAll(resume.getUserSkills());
			//skills
			LinkRepository.saveAll(resume.getLinks());
			
			result=1;
		}
		
		return result;
	}

	/**
	 * 이력서수정
	 */
	@Override
	public int updateResume(Resume resume) {
		Resume dbResume = ResumeRepository.findById(resume.getResumeId()).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else {
			dbResume.setResumeName(resume.getResumeName());
			dbResume.setResumePhone(resume.getResumePhone());
			dbResume.setResumeContent(resume.getResumeContent());
			dbResume.setEdus(resume.getEdus());
			dbResume.setCareers(resume.getCareers());
			dbResume.setLicenses(resume.getLicenses());
			dbResume.setLangs(resume.getLangs());
			dbResume.setUserSkills(resume.getUserSkills());
			dbResume.setLinks(resume.getLinks());
			result=1;
		}
		
		return result;
	}

	/**
	 * 이력서삭제
	 * 이력서 상태 변경
	 */
	@Override
	public int delete(Long resumeId) {
		Resume dbResume = ResumeRepository.findById(resumeId).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else {
			dbResume.setResumeStatus(3);
			result=1;
		}
		
		return result;
	}

	/**
	 * 이력서 상세보기
	 */
	@Override
	public Resume resumeDetail(Users user) {
		
		return null;
	}

	/**
	 * 이력서 목록보기
	 */
	@Override
	public List<Resume> recruitList(Users user) {
		
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
