package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.domain.Career;
import kosta.mvc.domain.Edu;
import kosta.mvc.domain.Lang;
import kosta.mvc.domain.LangClass;
import kosta.mvc.domain.LangLevel;
import kosta.mvc.domain.LangLicense;
import kosta.mvc.domain.License;
import kosta.mvc.domain.Link;
import kosta.mvc.domain.Project;
import kosta.mvc.domain.Resume;
import kosta.mvc.domain.Skills;
import kosta.mvc.domain.UserSkill;
import kosta.mvc.repository.CareerRepository;
import kosta.mvc.repository.EduRepository;
import kosta.mvc.repository.LangClassRepository;
import kosta.mvc.repository.LangLevelRepository;
import kosta.mvc.repository.LangLicenseRepository;
import kosta.mvc.repository.LangRepository;
import kosta.mvc.repository.LicenseRepository;
import kosta.mvc.repository.LinkRepository;
import kosta.mvc.repository.ProjectRepository;
import kosta.mvc.repository.ResumeRepository;
import kosta.mvc.repository.SkillsRepository;
import kosta.mvc.repository.UserSkillRepository;

@Service
public class ResumeServiceNew {

	@Autowired
	private ResumeRepository resumeRepo;

	@Autowired
	private LinkRepository linkRepo;

	@Autowired
	private EduRepository eduRepo;

	@Autowired
	private LicenseRepository licenseRepo;

	@Autowired
	private CareerRepository careerRepo;

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private LangRepository langRepo;

	@Autowired
	private LangLicenseRepository langLicenseRepo;

	@Autowired
	private LangClassRepository langClassRepo;

	@Autowired
	private LangLevelRepository langLevelRepo;

	@Autowired
	private UserSkillRepository userSkillRepo;
	
	@Autowired
	private SkillsRepository skillsRepo;

	@Transactional
	public Long insertResume(Resume resume) {
		resumeRepo.save(resume);
		return resume.getResumeId();
	}

	@Transactional
	public Long insertLink(Link link) {
		linkRepo.save(link);
		return link.getLinkId();
	}

	@Transactional
	public Long insertEdu(Edu edu) {
		eduRepo.save(edu);
		return edu.getEduId();
	}

	@Transactional
	public Long insertLicense(License license) {
		licenseRepo.save(license);
		return license.getLicenseId();
	}

	@Transactional
	public Long insertCareer(Career career) {
		careerRepo.save(career);
		return career.getCareerId();
	}

	@Transactional
	public Long insertProject(Project project) {
		projectRepo.save(project);
		return project.getProjectId();
	}

	@Transactional
	public Long insertLang(Lang lang) {
		langRepo.save(lang);
		return lang.getLangId();
	}

	@Transactional
	public Long insertLangClass(LangClass langClass) {
		langClassRepo.save(langClass);
		return langClass.getLangClassId();
	}

	@Transactional
	public Long insertLangLevel(LangLevel langLevel) {
		langLevelRepo.save(langLevel);
		return langLevel.getLangLevelId();
	}

	@Transactional
	public Long insertLangLicense(LangLicense langLicense) {
		langLicenseRepo.save(langLicense);
		return langLicense.getLangLicenseId();
	}

	@Transactional
	public Long insertUserSkill(UserSkill userSkill) {
		userSkillRepo.save(userSkill);
		return userSkill.getUserSkillId();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	@Transactional
	public int updateResume(Resume resume) {
		int result = 0;

		Resume dbResume = resumeRepo.findById(resume.getResumeId()).orElse(null);

		if (dbResume != null) {
			dbResume.setResumeContent(resume.getResumeContent());
			dbResume.setResumeName(resume.getResumeName());
			dbResume.setResumePhone(resume.getResumePhone());
			result = 1;
		}
		return result;
	}

	@Transactional
	public int updateLink(Link link) {
		int result = 0;

		Link dbLink = linkRepo.findById(link.getLinkId()).orElse(null);

		if (dbLink != null) {
			dbLink.setLinkContent(link.getLinkContent());
			result = 1;
		}

		return result;
	}

	@Transactional
	public int updateEdu(Edu edu) {
		int result = 0;

		Edu dbEdu = eduRepo.findById(edu.getEduId()).orElse(null);

		if (dbEdu != null) {
			dbEdu.setEduDetail(edu.getEduDetail());
			dbEdu.setEduGraduateAt(edu.getEduGraduateAt());
			dbEdu.setEduJoinAt(edu.getEduJoinAt());
			dbEdu.setEduName(edu.getEduName());
			dbEdu.setEduStatus(edu.getEduStatus());
			result = 1;
		}

		return result;
	}

	@Transactional
	public int updateLicense(License license) {
		int result = 0;

		License dbLicense = licenseRepo.findById(license.getLicenseId()).orElse(null);

		if (dbLicense != null) {
			dbLicense.setLicenseAt(license.getLicenseAt());
			dbLicense.setLicenseContent(license.getLicenseContent());
			dbLicense.setLicenseName(license.getLicenseName());
			result = 1;
		}

		return result;
	}

	@Transactional
	public int updateCareer(Career career) {
		int result = 0;

		Career dbCareer = careerRepo.findById(career.getCareerId()).orElse(null);

		if (dbCareer != null) {
			dbCareer.setCareerCompanyName(career.getCareerCompanyName());
			dbCareer.setCareerEndAt(career.getCareerEndAt());
			dbCareer.setCareerPosition(career.getCareerPosition());
			dbCareer.setCareerStartAt(career.getCareerStartAt());
			dbCareer.setCareerStatus(career.getCareerStatus());
			result = 1;
		}

		return result;
	}

	@Transactional
	public int updateProject(Project project) {
		int result = 0;

		Project dbProject = projectRepo.findById(project.getProjectId()).orElse(null);

		if (dbProject != null) {
			dbProject.setProjectName(project.getProjectName());
			dbProject.setProjectContent(project.getProjectContent());
			dbProject.setProjectStartAt(project.getProjectStartAt());
			dbProject.setProjectEndAt(project.getProjectEndAt());
			result = 1;

		}

		return result;
	}

	@Transactional
	public int updateLang(Lang lang) {
		int result = 0;

		Lang dbLang = langRepo.findById(lang.getLangId()).orElse(null);

		if (dbLang != null) {
			dbLang.setLangLevel(lang.getLangLevel());
			dbLang.setLangClass(lang.getLangClass());
			result = 1;
		}

		return result;
	}

	@Transactional
	public int updateLangClass(LangClass langClass) {
		int result = 0;

		LangClass dbLangClass = langClassRepo.findById(langClass.getLangClassId()).orElse(null);

		if (dbLangClass != null) {
			dbLangClass.setLangClassName(langClass.getLangClassName());
			result = 1;
		}

		return result;
	}

	@Transactional
	public int updateLangLevel(LangLevel langLevel) {
		int result = 0;

		LangLevel dbLangLevel = langLevelRepo.findById(langLevel.getLangLevelId()).orElse(null);

		if (dbLangLevel != null) {
			dbLangLevel.setLangLevelName(langLevel.getLangLevelName());
			result = 1;
		}

		return result;
	}

	@Transactional
	public int updateLangLicense(LangLicense langLicense) {
		int result = 0;

		LangLicense dbLangLicense = langLicenseRepo.findById(langLicense.getLangLicenseId()).orElse(null);

		if (dbLangLicense != null) {
			dbLangLicense.setLangLicenseName(langLicense.getLangLicenseName());
			dbLangLicense.setLangLicenseLevel(langLicense.getLangLicenseLevel());
			dbLangLicense.setLangLicenseAt(langLicense.getLangLicenseAt());
			result = 1;
		}

		return result;
	}

	@Transactional
	public int updateUserSkill(UserSkill userSkill) {
		int result = 0;

		UserSkill dbUserSkill = userSkillRepo.findById(userSkill.getUserSkillId()).orElse(null);

		if (dbUserSkill != null) {
			dbUserSkill.setSkill(userSkill.getSkill());
			result = 1;
		}

		return result;
	}

	//////////////////////////////////////////////////////////////////////////////////////////

	@Transactional
	public int deleteResume(Long resumeId) {

		int result = 0;

		Resume resume = resumeRepo.findById(resumeId).orElse(null);

		if (resume != null) {
			resumeRepo.delete(resume);
			result = 1;
		}
		return result;

	}

	@Transactional
	public int deleteLink(Long linkId) {

		int result = 0;

		Link link = linkRepo.findById(linkId).orElse(null);

		if (link != null) {
			linkRepo.delete(link);
			result = 1;
		}
		return result;

	}

	@Transactional
	public int deleteEdu(Long eduId) {

		int result = 0;

		Edu edu = eduRepo.findById(eduId).orElse(null);

		if (edu != null) {
			eduRepo.delete(edu);
			result = 1;
		}
		return result;

	}

	@Transactional
	public int deleteLicense(Long licenseId) {

		int result = 0;

		License license = licenseRepo.findById(licenseId).orElse(null);

		if (license != null) {
			licenseRepo.delete(license);
			result = 1;
		}

		return result;

	}

	@Transactional
	public int deleteCareer(Long careerId) {

		int result = 0;

		Career career = careerRepo.findById(careerId).orElse(null);

		if (career != null) {
			careerRepo.delete(career);
			result = 1;
		}
		return result;

	}

	@Transactional
	public int deleteProject(Long projectId) {

		int result = 0;

		Project project = projectRepo.findById(projectId).orElse(null);

		if (project != null) {
			projectRepo.delete(project);
			result = 1;
		}
		return result;

	}

	@Transactional
	public int deleteLang(Long langId) {

		int result = 0;

		Lang lang = langRepo.findById(langId).orElse(null);

		if (lang != null) {
			langRepo.delete(lang);
			result = 1;
		}
		return result;

	}

	@Transactional
	public int deleteLangClass(Long langClassId) {

		int result = 0;
		
		LangClass langClass = langClassRepo.findById(langClassId).orElse(null);
		
		if(langClass != null) {
			langClassRepo.delete(langClass);
			result = 1;
		}

		return result;

	}

	@Transactional
	public int deleteLangLevel(Long langLevelId) {

		int result = 0;

		LangLevel langLevel = langLevelRepo.findById(langLevelId).orElse(null);
		
		if(langLevel!=null) {
			langLevelRepo.delete(langLevel);
			result = 1;
		}
		return result;

	}

	@Transactional
	public int deleteLangLicense(Long langLicenseId) {

		int result = 0;
		
		LangLicense langLicense = langLicenseRepo.findById(langLicenseId).orElse(null);
		
		if(langLicense!=null) {
			langLicenseRepo.delete(langLicense);
			result = 1;
		}

		return result;

	}

	@Transactional
	public int deleteUserSkill(Long userSkillId) {

		int result = 0;

		UserSkill userSkill = userSkillRepo.findById(userSkillId).orElse(null);
		
		if(userSkill!=null) {
			userSkillRepo.delete(userSkill);
			result = 1;
		}
		
		return result;

	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Resume findResume(Long resumeId) {
		return resumeRepo.findById(resumeId).orElse(null);
	}
	
	public Link findLink(Long linkId) {
		return linkRepo.findById(linkId).orElse(null);
	}
	
	public Edu findEdu(Long eduId) {
		return eduRepo.findById(eduId).orElse(null);
	}
	
	public License findLicense(Long licenseId) {
		return licenseRepo.findById(licenseId).orElse(null);
	}
	
	public Career findCareer(Long careerId) {
		return careerRepo.findById(careerId).orElse(null);
	}
	
	public Project findProject(Long projectId) {
		return projectRepo.findById(projectId).orElse(null);
	}
	
	public Lang findLang(Long langId) {
		return langRepo.findById(langId).orElse(null);
	}
	
	public LangClass findLangClass(Long langClassId) {
		return langClassRepo.findById(langClassId).orElse(null);
	}
	
	public LangLevel findLangLevel(Long langLevelId) {
		return langLevelRepo.findById(langLevelId).orElse(null);
	}
	
	public LangLicense findLangLicense(Long langLicenseId) {
		return langLicenseRepo.findById(langLicenseId).orElse(null);
	}
	
	public UserSkill findUserSkill(Long userSkillId) {
		return userSkillRepo.findById(userSkillId).orElse(null);
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	
	public List<LangClass> findAllLangClass() {
		return langClassRepo.findAll();
	}
	
	public List<LangLevel> findAllLangLevel(){
		return langLevelRepo.findAll();
	}
	
	public List<Skills> findAllSkills(){
		return skillsRepo.findAll();
	}
	

}
