package kosta.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Career;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Edu;
import kosta.mvc.domain.Lang;
import kosta.mvc.domain.LangClass;
import kosta.mvc.domain.LangLevel;
import kosta.mvc.domain.LangLicense;
import kosta.mvc.domain.License;
import kosta.mvc.domain.Link;
import kosta.mvc.domain.Project;
import kosta.mvc.domain.Resume;
import kosta.mvc.domain.ResumeRead;
import kosta.mvc.domain.UserSkill;
import kosta.mvc.domain.Users;
import kosta.mvc.repository.CareerRepository;
import kosta.mvc.repository.EduRepository;
import kosta.mvc.repository.LangClassRepository;
import kosta.mvc.repository.LangLevelRepository;
import kosta.mvc.repository.LangLicenseRepository;
import kosta.mvc.repository.LangRepository;
import kosta.mvc.repository.LicenseRepository;
import kosta.mvc.repository.LinkRepository;
import kosta.mvc.repository.MembersRepository;
import kosta.mvc.repository.ProjectRepository;
import kosta.mvc.repository.ResumeReadRepository;
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
	
	@Autowired
	private ProjectRepository ProjectRepository;
	
	@Autowired
	private LangClassRepository LangClassRepository;
	
	@Autowired
	private LangLevelRepository LangLevelRepository;
	
	@Autowired
	private LangLicenseRepository LangLicenseRepository;
	
	@Autowired
	private ResumeReadRepository ResumeReadRepository;
	
	/**
	 * 회원가입 result 1-성공, result 0-실패 
	 */
	@Override
	public int insertUser(Users user) {
		
		int result;
		
		if(user==null) {
			result=0;
		}else {
			UsersRepository.save(user);
			MembersRepository.save(user.getMember());
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
			dbuser.getMember().setKakaoId(user.getMember().getKakaoId());
			dbuser.getMember().setMemberEmail(user.getMember().getMemberEmail());
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
		//List<Project> projectlist = new ArrayList<Project>();
		//List<LangLicense> langlicenlist = new ArrayList<LangLicense>();
		
		if(resume==null) {
			result=0;
		}else {
			ResumeRepository.save(resume);
			/*EduRepository.saveAll(resume.getEdus());
			CareerRepository.saveAll(resume.getCareers());
			LicenseRepository.saveAll(resume.getLicenses());
			LangRepository.saveAll(resume.getLangs());
			for(int i=0; i<resume.getLangs().size(); i++) {
				Lang lang = resume.getLangs().get(i);
				LangClassRepository.save(lang.getLangClass());
			}
			
			for(int i=0; i<resume.getLangs().size(); i++) {
				Lang lang = resume.getLangs().get(i);
				LangLevelRepository.save(lang.getLangLevel());
			}
			
			for(int i=0;i<resume.getLangs().size();i++) {
				Lang lang = resume.getLangs().get(i);
				for(LangLicense lic : lang.getLangLicenses()) {
					langlicenlist.add(lic);
				}
			}
			LangLicenseRepository.saveAll(langlicenlist);
			UserSkillRepository.saveAll(resume.getUserSkills());
			LinkRepository.saveAll(resume.getLinks());*/
			
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 등록 학력
	 */
	@Override
	public int insertEdu(Resume resume) {
		Resume dbResume=ResumeRepository.findById(resume.getResumeId()).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else {
			EduRepository.saveAll(resume.getEdus());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 등록 커리어
	 */
	@Override
	public int insertCareer(Resume resume) {
		Resume dbResume = ResumeRepository.findById(resume.getResumeId()).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else {
			CareerRepository.saveAll(resume.getCareers());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 등록 커리어-프로젝트
	 */
	@Override
	public int insertProject(Career career) {
		Career dbCareer = CareerRepository.findById(career.getCareerId()).orElse(null);
		int result;
		
		if(dbCareer==null) {
			result=0;
		}else {
			ProjectRepository.saveAll(career.getProjects());
			result=1;
		}
		
		return result;
		
	}
	

	/**
	 * 이력서 등록 자격증
	 */
	@Override
	public int insertLicense(Resume resume) {
		Resume dbResume = ResumeRepository.findById(resume.getResumeId()).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else {
			LicenseRepository.saveAll(resume.getLicenses());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 등록 언어
	 */
	@Override
	public int insertLang(Resume resume) {
		Resume dbResume = ResumeRepository.findById(resume.getResumeId()).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else {
			LangRepository.saveAll(resume.getLangs());
			result=1;
		}
		return result;
	
	}
	
	/**
	 * 이력서 등록 언어-클래스
	 */
	@Override
	public int insertClass(Lang lang) {
		Lang dbLang = LangRepository.findById(lang.getLangId()).orElse(null);
		int result;
		
		if(dbLang==null) {
			result=0;
		}else {
			LangClassRepository.save(lang.getLangClass());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 등록 언어-레벨
	 */
	@Override
	public int insertLevel(Lang lang) {
		Lang dbLang = LangRepository.findById(lang.getLangId()).orElse(null);
		int result;
		
		if(dbLang==null) {
			result=0;
		}else {
			LangLevelRepository.save(lang.getLangLevel());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 등록 언어-라이센스
	 */
	@Override
	public int insertLangLicense(Lang lang) {
		Lang dbLang = LangRepository.findById(lang.getLangId()).orElse(null);
		int result;
		
		if(dbLang==null) {
			result=0;
		}else {
			LangLicenseRepository.saveAll(lang.getLangLicenses());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 등록 유저스킬
	 */
	@Override
	public int insertUserSkill(Resume resume) {
		Resume dbResume = ResumeRepository.findById(resume.getResumeId()).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else {
			UserSkillRepository.saveAll(resume.getUserSkills());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 등록 링크 
	 */
	@Override
	public int insertLink(Resume resume) {
		Resume dbResume = ResumeRepository.findById(resume.getResumeId()).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else {
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
			/*dbResume.setEdus(resume.getEdus());
			dbResume.setCareers(resume.getCareers());
			dbResume.setLicenses(resume.getLicenses());
			dbResume.setLangs(resume.getLangs());
			dbResume.setUserSkills(resume.getUserSkills());
			dbResume.setLinks(resume.getLinks());*/
			result=1;
		}
		
		return result;
	}

	/**
	 * 이력서 수정 학력
	 */
	@Override
	public int updateEdu(Edu edu) {
		Edu dbEdu = EduRepository.findById(edu.getEduId()).orElse(null);
		
		int result;
		
		if(dbEdu==null) {
			result=0;
		}else {
			dbEdu.setEduJoinAt(edu.getEduJoinAt());
			dbEdu.setEduGraduateAt(edu.getEduGraduateAt());
			dbEdu.setEduStatus(edu.getEduStatus());
			dbEdu.setEduName(edu.getEduName());
			dbEdu.setEduDetail(edu.getEduDetail());
			result=1;
		}
	
		return result;
	}
	
	/**
	 * 이력서 수정 커리어
	 */
	@Override
	public int updateCareer(Career career) {
		Career dbCareer = CareerRepository.findById(career.getCareerId()).orElse(null);
		int result;
		
		if(dbCareer==null) {
			result=0;
		}else {
			dbCareer.setCareerCompanyName(career.getCareerCompanyName());
			dbCareer.setCareerPosition(career.getCareerPosition());
			dbCareer.setCareerStartAt(career.getCareerStartAt());
			dbCareer.setCareerEndAt(career.getCareerEndAt());
			dbCareer.setCareerStatus(career.getCareerStatus());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 수정 커리어-프로젝트
	 */
	@Override
	public int updateProject(Project project) {
		Project dbProject = ProjectRepository.findById(project.getProjectId()).orElse(null);
		int result;
		
		if(dbProject==null) {
			result=0;
		}else {
			dbProject.setProjectName(project.getProjectName());
			dbProject.setProjectStartAt(project.getProjectStartAt());
			dbProject.setProjectEndAt(project.getProjectEndAt());
			dbProject.setProjectContent(project.getProjectContent());
			
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 수정 자격증
	 */
	@Override
	public int updateLicense(License license) {
		License dbLicense = LicenseRepository.findById(license.getLicenseId()).orElse(null);
		int result;
		
		if(dbLicense==null) {
			result=0;
		}else {
			dbLicense.setLicenseAt(license.getLicenseAt());
			dbLicense.setLicenseName(license.getLicenseName());
			dbLicense.setLicenseContent(license.getLicenseContent());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 수정 언어
	 */
	@Override
	public int updateLang(Lang lang) {
		Lang dbLang = LangRepository.findById(lang.getLangId()).orElse(null);
		int result;
		
		if(dbLang==null) {
			result=0;
		}else {
			
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 수정 언어 클래스
	 */
	@Override
	public int updateLangClass(LangClass langClass) {
		LangClass dbClass = LangClassRepository.findById(langClass.getLangClassId()).orElse(null);
		int result;
		
		if(dbClass==null) {
			result=0;
		}else {
			dbClass.setLangClassName(langClass.getLangClassName());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 수정 언어 레벨
	 */
	@Override
	public int updateLangLevel(LangLevel langLevel) {
		LangLevel dbLangLevel = LangLevelRepository.findById(langLevel.getLangLevelId()).orElse(null);
		int result;
		
		if(dbLangLevel==null) {
			result=0;
		}else {
			dbLangLevel.setLangLevelName(langLevel.getLangLevelName());
			result=1;
		}
		
		return result;
		
	}
	
	/**
	 * 이력서 수정 언어 자격증
	 */
	@Override
	public int updateLangLicense(LangLicense langLicense) {
		LangLicense dbLangLicense = LangLicenseRepository.findById(langLicense.getLangLicenseId()).orElse(null);
		int result;
		
		if(dbLangLicense==null) {
			result=0;
		}else {
			dbLangLicense.setLangLicenseName(langLicense.getLangLicenseName());
			dbLangLicense.setLangLicenseAt(langLicense.getLangLicenseAt());
			dbLangLicense.setLangLicenseLevel(langLicense.getLangLicenseLevel());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 수정 유저스킬
	 */
	@Override
	public int updateUserSkill(UserSkill userSkill) {
		UserSkill dbUserSkill = UserSkillRepository.findById(userSkill.getUserSkillId()).orElse(null);
		int result;
		
		if(dbUserSkill==null) {
			result=0;
		}else {
			dbUserSkill.setSkill(userSkill.getSkill());
			result=1;
		}
		
		return result;
	}
	
	/**
	 * 이력서 수정 링크
	 */
	@Override
	public int updateLink(Link link) {
		Link dbLink = LinkRepository.findById(link.getLinkId()).orElse(null);
		int result;
		
		if(dbLink==null) {
			result=0;
		}else {
			dbLink.setLinkContent(link.getLinkContent());
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
	public Resume resumeDetail(Resume resume) {
		Resume dbResume = ResumeRepository.findById(resume.getResumeId()).orElse(null);
		
		
		return dbResume;
	}

	/**
	 * 이력서 목록보기
	 */
	@Override
	public List<Resume> resumeList(Users user) {
		Users dbuser = UsersRepository.findById(user.getUserId()).orElse(null);
		List<Resume> resumelist = new ArrayList<Resume>();
			
		if(dbuser==null) {
			
		}
		
		for(Resume res : dbuser.getResumes()) {
			resumelist.add(res);
		}
		
		return resumelist;
	}

	/**
	 * 이력서 온/오프
	 * 이력서 상태
	 */
	@Override
	public int resumeOnOff(Resume resume) {
		Resume dbResume = ResumeRepository.findById(resume.getResumeId()).orElse(null);
		int result;
		
		if(dbResume==null) {
			result=0;
		}else if(resume.getResumeStatus()==1) {
			dbResume.setResumeStatus(2);
			result=1;
		}else {
			dbResume.setResumeStatus(1);
			result=1;
		}
		
		return result;
	}

	/**
	 * 오픈이력서 조회기업목록
	 */
	@Override
	public List<Companys> readCompany(ResumeRead resumeRead) {
		ResumeRead dbResumeRead = ResumeReadRepository.findById(resumeRead.getResumeReadId()).orElse(null);
		
		
		return null;
	}

}
