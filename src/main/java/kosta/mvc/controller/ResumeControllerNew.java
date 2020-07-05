package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kosta.mvc.DTO.CareerDTO;
import kosta.mvc.DTO.EduDTO;
import kosta.mvc.DTO.LangClassDTO;
import kosta.mvc.DTO.LangDTO;
import kosta.mvc.DTO.LangLevelDTO;
import kosta.mvc.DTO.LangLicenseDTO;
import kosta.mvc.DTO.LicenseDTO;
import kosta.mvc.DTO.LinkDTO;
import kosta.mvc.DTO.ProjectDTO;
import kosta.mvc.DTO.ResumeDTO;
import kosta.mvc.DTO.UserSkillDTO;
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
import kosta.mvc.domain.Users;
import kosta.mvc.service.ResumeServiceNew;

@RestController
@RequestMapping("/resume")
@Api(tags = {"new 이력서 controller"})
public class ResumeControllerNew {

	@Autowired
	private ResumeServiceNew resumeService;

	/*
	 * insertPart: return = 해당 Entity의 등록된 id값
	 */

	@PostMapping("/insertResume")
	public Long insertResume(@RequestBody Long userId) throws IOException {
		Users user = new Users();
		user.setUserId(userId);
		Resume resume = new Resume();
		resume.setUser(user);
		return resumeService.insertResume(resume);
	}

	@PostMapping("/insertEdu")
	public Long insertEdu(@RequestBody Long resumeId) throws IOException {
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		Edu edu = new Edu();
		edu.setResume(resume);
		return resumeService.insertEdu(edu);
	}

	@PostMapping("/insertCareer")
	public Long insertCareer(@RequestBody Long resumeId) throws IOException {
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		Career career = new Career();
		career.setResume(resume);
		return resumeService.insertCareer(career);
	}

	@PostMapping("/insertProject")
	public Long insertProject(@RequestBody Long careerId) throws IOException {
		Career career = new Career();
		career.setCareerId(careerId);
		Project project = new Project();
		project.setCareer(career);
		return resumeService.insertProject(project);
	}

	@PostMapping("/insertLicense")
	public Long insertLicense(@RequestBody Long resumeId) throws IOException {
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		License license = new License();
		license.setResume(resume);
		return resumeService.insertLicense(license);
	}

	@PostMapping("/insertLang")
	public Long insertLang(@RequestBody Long resumeId) throws IOException {
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		Lang lang = new Lang();
		lang.setResume(resume);
		return resumeService.insertLang(lang);
	}

	@PostMapping("/insertLangClass")
	public Long insertLangClass(@RequestBody LangClassDTO langClassDTO) throws IOException {
		LangClass langClass = new LangClass(langClassDTO);
		return resumeService.insertLangClass(langClass);
	}

	@PostMapping("/insertLangLevel")
	public Long insertLangLevel(@RequestBody LangLevelDTO langLevelDTO) throws IOException {
		LangLevel langLevel = new LangLevel(langLevelDTO);
		return resumeService.insertLangLevel(langLevel);
	}

	@PostMapping("/insetLangLicense")
	public Long insertLangLicense(@RequestBody Long langId) throws IOException {
		Lang lang = new Lang();
		lang.setLangId(langId);
		LangLicense langLicense = new LangLicense();
		langLicense.setLang(lang);
		return resumeService.insertLangLicense(langLicense);
	}

	@PostMapping("/insertUserSkill")
	public Long insertUserSkill(@RequestBody Long resumeId, @RequestBody Long skillId) throws IOException {
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		Skills skill = new Skills();
		skill.setSkillId(skillId);
		UserSkill userSkill = new UserSkill();
		userSkill.setResume(resume);
		userSkill.setSkill(skill);
		return resumeService.insertUserSkill(userSkill);
	}

	@PostMapping("/insertLink")
	public Long insertLink(@RequestBody Long resumeId) throws IOException {
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		Link link = new Link();
		link.setResume(resume);
		return resumeService.insertLink(link);
	}

	/////////////////////////////////////////

	/*
	 * updatePart: return = 1.성공 0.실패
	 */

	@PostMapping("/updateResume")
	public int updateResume(@RequestBody ResumeDTO resumeDTO) throws NotFoundException {
		Resume resume = new Resume(resumeDTO);
		return resumeService.updateResume(resume);
	}

	@PostMapping("/updateEdu")
	public int updateEdu(@RequestBody EduDTO eduDTO) throws NotFoundException {
		Edu edu = new Edu(eduDTO);
		return resumeService.updateEdu(edu);
	}

	@PostMapping("/updateCareer")
	public int updateCareer(@RequestBody CareerDTO careerDTO) throws NotFoundException {
		Career career = new Career(careerDTO);
		return resumeService.updateCareer(career);
	}

	@PostMapping("/updateProject")
	public int updateProject(@RequestBody ProjectDTO projectDTO) throws NotFoundException {
		Project project = new Project(projectDTO);
		return resumeService.updateProject(project);
	}

	@PostMapping("/updateLicense")
	public int updateLicense(@RequestBody LicenseDTO licenseDTO) throws NotFoundException {
		License license = new License(licenseDTO);
		return resumeService.updateLicense(license);
	}

	@PostMapping("/updateLang")
	public int updateLang(@RequestBody LangDTO langDTO) throws NotFoundException {
		Lang lang = new Lang(langDTO);
		return resumeService.updateLang(lang);
	}

	@PostMapping("/updateLangClass")
	public int updateLangClass(@RequestBody LangClassDTO langClassDTO) throws NotFoundException {
		LangClass langClass = new LangClass(langClassDTO);
		return resumeService.updateLangClass(langClass);
	}

	@PostMapping("/updateLangLevel")
	public int updateLangLevel(@RequestBody LangLevelDTO langLevelDTO) throws NotFoundException {
		LangLevel langLevel = new LangLevel(langLevelDTO);
		return resumeService.updateLangLevel(langLevel);
	}

	@PostMapping("/updateLangLicense")
	public int updateLangLicense(@RequestBody LangLicenseDTO langLicenseDTO) throws NotFoundException {
		LangLicense langLicense = new LangLicense(langLicenseDTO);
		return resumeService.updateLangLicense(langLicense);
	}

	@PostMapping("/updateUserSkill")
	public int updateUserSkill(@RequestBody UserSkillDTO userSkillDTO) throws NotFoundException {
		UserSkill userSkill = new UserSkill(userSkillDTO);
		return resumeService.updateUserSkill(userSkill);
	}

	@PostMapping("/updateLink")
	public int updateLink(@RequestBody LinkDTO linkDTO) throws NotFoundException {
		Link link = new Link(linkDTO);
		return resumeService.updateLink(link);
	}
	//////////////////////////////////////////////////////////

	/*
	 * deletePart: return= 1.성공 0.실패
	 */
	@PostMapping("/deleteResume")
	public int deleteResume(@RequestBody Long resumeId) throws IOException, NotFoundException {
		return resumeService.deleteResume(resumeId);
	}

	@PostMapping("/deleteLink")
	public int deleteLink(@RequestBody Long linkId) throws IOException, NotFoundException {
		return resumeService.deleteLink(linkId);
	}

	@PostMapping("/deleteEdu")
	public int deleteEdu(@RequestBody Long eduId) throws IOException, NotFoundException {
		return resumeService.deleteEdu(eduId);
	}

	@PostMapping("/deleteLicense")
	public int deleteLicense(@RequestBody Long licenseId) throws IOException, NotFoundException {
		return resumeService.deleteLicense(licenseId);
	}

	@PostMapping("/deleteCareer")
	public int deleteCareer(@RequestBody Long careerId) throws IOException, NotFoundException {
		return resumeService.deleteCareer(careerId);
	}

	@PostMapping("/deleteProject")
	public int deleteProject(@RequestBody Long projectId) throws IOException, NotFoundException {
		return resumeService.deleteProject(projectId);
	}

	@PostMapping("/deleteLang")
	public int deleteLang(@RequestBody Long langId) throws IOException, NotFoundException {
		return resumeService.deleteLang(langId);
	}

	@PostMapping("/deleteLangClass")
	public int deleteLangClass(@RequestBody Long langClassId) throws IOException, NotFoundException {
		return resumeService.deleteLangClass(langClassId);
	}

	@PostMapping("/deleteLevel")
	public int deleteLangLevel(@RequestBody Long langLevelId) throws IOException, NotFoundException {
		return resumeService.deleteLangLevel(langLevelId);
	}

	@PostMapping("/deleteLangLicense")
	public int deleteLangLicense(@RequestBody Long langLicenseId) throws IOException, NotFoundException {
		return resumeService.deleteLangLicense(langLicenseId);
	}

	@PostMapping("/deleteUserSkill")
	public int deleteUserSkill(@RequestBody Long userSkillId) throws IOException, NotFoundException {
		return resumeService.deleteUserSkill(userSkillId);
	}

	///////////////////////////////////////////////////////////////
	
	/*
	 * readPart
	 * */
	
	@PostMapping("/resume/{resumeId}")
	public Resume findResume(@PathVariable String resumeId) throws IOException, NotFoundException {
		Long id = Long.parseLong(resumeId);
		return resumeService.findResume(id);
	}

	@PostMapping("/link/{linkId}")
	public Link findLink(@PathVariable String linkId) throws IOException, NotFoundException {
		Long id = Long.parseLong(linkId);
		return resumeService.findLink(id);
	}

	@PostMapping("/edu/{eduId}")
	public Edu findEdu(@PathVariable String eduId) throws IOException, NotFoundException {
		Long id = Long.parseLong(eduId);
		return resumeService.findEdu(id);
	}

	@PostMapping("/license/{licenseId}")
	public License findLicense(@PathVariable String licenseId) throws IOException, NotFoundException {
		Long id = Long.parseLong(licenseId);
		return resumeService.findLicense(id);
	}

	@PostMapping("/career/{careerId}")
	public Career findCareer(@PathVariable String careerId) throws IOException, NotFoundException {
		Long id = Long.parseLong(careerId);
		return resumeService.findCareer(id);
	}

	@PostMapping("/project/{projectId}")
	public Project findProject(@PathVariable String projectId) throws IOException, NotFoundException {
		Long id = Long.parseLong(projectId);
		return resumeService.findProject(id);
	}

	@PostMapping("/lang/{langId}")
	public Lang findLang(@PathVariable String langId) throws IOException, NotFoundException {
		Long id = Long.parseLong(langId);
		return resumeService.findLang(id);
	}

	@PostMapping("/langClass/{langClassId}")
	public LangClass findLangClass(@PathVariable String langClassId) throws IOException, NotFoundException {
		Long id = Long.parseLong(langClassId);
		return resumeService.findLangClass(id);
	}

	@PostMapping("/langLevel/{langLevelId}")
	public LangLevel findLangLevel(@PathVariable String langLevelId) throws IOException, NotFoundException {
		Long id = Long.parseLong(langLevelId);
		return resumeService.findLangLevel(id);
	}

	@PostMapping("/langLicense/{langLicenseId}")
	public LangLicense findLangLicense(@PathVariable String langLicenseId) throws IOException, NotFoundException {
		Long id = Long.parseLong(langLicenseId);
		return resumeService.findLangLicense(id);
	}

	@PostMapping("/userSkill/{userSkillId}")
	public UserSkill findUserSkill(@PathVariable String userSkillId) throws IOException, NotFoundException {
		Long id = Long.parseLong(userSkillId);
		return resumeService.findUserSkill(id);
	}

///////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/langClassList")
	public List<LangClass> findAllLangClass(){
		return resumeService.findAllLangClass();
	}
	
	@GetMapping("/langLevelList")
	public List<LangLevel> findAllLangLevel(){
		return resumeService.findAllLangLevel();
	}
	
	@GetMapping("/skillList")
	public List<Skills> findAllSkills(){
		return resumeService.findAllSkills();
	}
	
	
	
	/**
	 * 이력서 온/오프 result 1-온, result 0-오프
	 */
	/*
	 * @ApiOperation(value = "이력서 오픈여부")
	 * 
	 * @RequestMapping("/resumeOnOff") public int
	 * resumeOnOff(@ApiParam("설정할 이력서 정보")Resume resume) throws IOException,
	 * NotFoundException{ int result = resumeService.resumeOnOff(resume);
	 * 
	 * return result; }
	 */

	/**
	 * 오픈이력서 조회기업목록
	 */
	/*
	 * @ApiOperation(value = "이력서를 본 기업목록")
	 * 
	 * @RequestMapping("/readCompany") public List<Companys>
	 * readCompany(@ApiParam("목록을 볼 유저정보")Users user) throws IOException,
	 * NotFoundException{ List<Companys> comList = resumeService.readCompany(user);
	 * 
	 * return comList; }
	 */

	/**
	 * 예외 처리
	 */
	@ExceptionHandler(NotFoundException.class)
	public String notFoundError(Exception e) {

		return e.getMessage();
	}

	/**
	 * 예외 처리
	 */
	@ExceptionHandler(IOException.class)
	public String ioError(Exception e) {

		return e.getMessage();
	}

}