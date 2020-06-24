package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kosta.mvc.domain.Career;
//import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Edu;
import kosta.mvc.domain.Lang;
import kosta.mvc.domain.LangClass;
import kosta.mvc.domain.LangLevel;
import kosta.mvc.domain.LangLicense;
import kosta.mvc.domain.License;
import kosta.mvc.domain.Link;
import kosta.mvc.domain.Project;
import kosta.mvc.domain.Resume;
import kosta.mvc.domain.UserSkill;
import kosta.mvc.domain.Users;
import kosta.mvc.service.ResumeService;


@RestController
@RequestMapping("/resume")
@Api(tags = {"이력서 controller"})
@Transactional
public class ResumeController {

	@Autowired
	private ResumeService resumeService;
	
	/**
	 * 이력서 등록 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 등록하기")
	@RequestMapping("/insertResume")
	public int insertResume(@ApiParam("등록할 이력서 정보")Resume resume) throws IOException {
		int result = resumeService.insertResume(resume);
		
		return result;
	}
	
	/**
	 * 이력서 등록 학력 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 학력 등록")
	@RequestMapping("/insertEdu")
	public int insertEdu(@ApiParam("학력정보가 포함될 이력서정보")Resume resume) throws IOException {
		int result = resumeService.insertEdu(resume);
		
		return result;
	}
	
	/**
	 * 이력서 등록 커리어 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 커리어 등록")
	@RequestMapping("/insertCareer")
	public int insertCareer(@ApiParam("커리어정보가 포함될 이력서정보")Resume resume) throws IOException {
		int result = resumeService.insertCareer(resume);
		
		return result;
	}
	
	/**
	 * 이력서 등록 커리어-프로젝트 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 커리어-프로젝트 등록")
	@RequestMapping("/insertProject")
	public int insertProject(@ApiParam("프로젝트정보가 포함될 커리어정보")Career career) throws IOException {
		int result = resumeService.insertProject(career);
		
		return result;
	}
	
	/**
	 * 이력서 등록 자격증 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 자격증 등록")
	@RequestMapping("/insertLicense")
	public int insertLicense(@ApiParam("자격증정보가 포함될 이력서정보")Resume resume) throws IOException {
		int result = resumeService.insertLicense(resume);
		
		return result;
	}
	
	/**
	 * 이력서 등록 언어 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 언어 등록")
	@RequestMapping("/insertLang")
	public int insertLang(@ApiParam("언어정보가 포함될 이력서정보")Resume resume) throws IOException {
		int result=resumeService.insertLang(resume);
		
		return result;
	}
	
	/**
	 * 이력서 등록 언어-클래스 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 언어-클래스 등록")
	@RequestMapping("/insertLangClass")
	public int insertLangClass(@ApiParam("클래스정보가 포함될 언어정보")Lang lang) throws IOException{
		int result = resumeService.insertClass(lang);;
		
		return result;
	}
	
	/**
	 * 이력서 등록 언어-레벨 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 언어-레벨 등록")
	@RequestMapping("/insertLangLevel")
	public int insertLangLevel(@ApiParam("레벨정보가 포함될 언어정보")Lang lang) throws IOException{
		int result=resumeService.insertLevel(lang);
		
		return result;
	}
	
	/**
	 * 이력서 등록 언어-라이센스 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 언어-자격증 등록")
	@RequestMapping("/insetLangLicense")
	public int insertLangLicense(@ApiParam("자격증정보가 포함될 언어정보")Lang lang) throws IOException {
		int result=resumeService.insertLangLicense(lang);
		
		return result;
	}
	
	/**
	 * 이력서 등록 유저스킬 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 스킬등록")
	@RequestMapping("/insertUserSkill")
	public int insertUserSkill(@ApiParam("스킬이 포함될 이력서정보")Resume resume) throws IOException{
		int result=resumeService.insertUserSkill(resume);
		
		return result;
	}
	
	/**
	 * 이력서 등록 링크  성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 링크 등록")
	@RequestMapping("/insertLink")
	public int insertLink(Resume resume) throws IOException{
		int result = resumeService.insertLink(resume);
		
		return result;
	}
	
	/**
	 * 이력서 수정하기 성공 result=1 실패 result=0
	 */
	@ApiOperation(value = "이력서 수정하기")
	@RequestMapping("/updateResume")
	public int updateResume(@ApiParam("수정할 이력서 정보")Resume resume) throws NotFoundException {
		int result = resumeService.updateResume(resume);
		
		return result;
	}
	
	/**
	 * 이력서 수정 학력 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 학력 수정")
	@RequestMapping("/updateEdu")
	public int updateEdu(@ApiParam("수정할 학력정보")Edu edu) throws NotFoundException {
		int result = resumeService.updateEdu(edu);
		
		return result;
	}
	
	/**
	 * 이력서 수정 커리어 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 커리어 수정")
	@RequestMapping("/updateCareer")
	public int updateCareer(@ApiParam("수정할 커리어정보")Career career) throws NotFoundException{
		int result = resumeService.updateCareer(career);
		
		return result;
	}
	
	/**
	 * 이력서 수정 커리어-프로젝트 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 커리어-프로젝트 수정")
	@RequestMapping("/updateProject")
	public int updateProject(@ApiParam("수정할 프로젝트정보")Project project) throws NotFoundException{
		int result = resumeService.updateProject(project);
		
		return result;
	}
	
	/**
	 * 이력서 수정 자격증 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 자격증 수정")
	@RequestMapping("/updateLicense")
	public int updateLicense(@ApiParam("수정할 자격증정보")License license) throws NotFoundException{
		int result = resumeService.updateLicense(license);
		
		return result;
	}
	
	/**
	 * 이력서 수정 언어 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 언어 수정")
	@RequestMapping("/updateLang")
	public int updateLang(@ApiParam("수정할 언어정보")Lang lang) throws NotFoundException{
		int result = resumeService.updateLang(lang);
		
		return result;
	}
	
	/**
	 * 이력서 수정 언어 클래스 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 언어-클래스 수정")
	@RequestMapping("/updateLangClass")
	public int updateLangClass(@ApiParam("수정할 언어클래스정보")LangClass langClass) throws NotFoundException{
		int result = resumeService.updateLangClass(langClass);
		
		return result;
	}
	
	/**
	 * 이력서 수정 언어 레벨 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 언어-레벨 수정")
	@RequestMapping("/updateLangLevel")
	public int updateLangLevel(@ApiParam("수정할 언어레벨정보")LangLevel langLevel) throws NotFoundException{
		int result = resumeService.updateLangLevel(langLevel);
		
		return result;
	}
	
	/**
	 * 이력서 수정 언어 자격증 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 언어-자격증 수정")
	@RequestMapping("/updateLangLicense")
	public int updateLangLicense(@ApiParam("수정할 언어자격증정보")LangLicense langLicense) throws NotFoundException{
		int result = resumeService.updateLangLicense(langLicense);
		
		return result;
	}
	
	/**
	 * 이력서 수정 유저스킬 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 유저스킬 수정")
	@RequestMapping("/updateUserSkill")
	public int updateUserSkill(@ApiParam("수정할 유저스킬정보")UserSkill userSkill) throws NotFoundException{
		int result = resumeService.updateUserSkill(userSkill);
		
		return result;
	}
	
	/**
	 * 이력서 수정 링크 성공 result=1 실패 result=0
	 */
	@ApiOperation("이력서 링크 수정")
	@RequestMapping("/updateLink")
	public int updateLink(@ApiParam("수정할 링크정보")Link link) throws NotFoundException{
		int result = resumeService.updateLink(link);
		
		return result;
	}
	
	/**
	 * 이력서 삭제하기 성공 result=1 실패 result=0
	 * 삭제상태 resumeStatus - 3
	 */
	@ApiOperation(value = "이력서 삭제하기")
	@RequestMapping("/deleteResume")
	public int deleteResume(@ApiParam("삭제할 이력서의 ID")Long resumeId) throws IOException, NotFoundException {
		int result = resumeService.deleteResume(resumeId);
		
		return result;
	}
	
	/**
	 * 이력서 상세보기
	 */
	@ApiOperation(value = "이력서 상세보기")
	@RequestMapping("/resumeDetail")
	public Resume resumeDetail(@ApiParam("클릭된 이력서")Resume resume) throws IOException, NotFoundException{
		Resume resultResume = resumeService.resumeDetail(resume);
		
		return resultResume;
	}
	
	/**
	 * 이력서 목록보기
	 */
	@ApiOperation(value = "이력서 목록보기")
	@RequestMapping("/resumeList")
	public List<Resume> resumeList(@ApiParam("이력서를 가진 유저정보")Users user) throws IOException, NotFoundException{
		List<Resume> resumeList = resumeService.resumeList(user);
		
		return resumeList;
	}
	
	/**
	 * 이력서 온/오프 result 1-온, result 0-오프
	 */
	/*@ApiOperation(value = "이력서 오픈여부")
	@RequestMapping("/resumeOnOff")
	public int resumeOnOff(@ApiParam("설정할 이력서 정보")Resume resume) throws IOException, NotFoundException{
		int result = resumeService.resumeOnOff(resume);
		
		return result;
	}*/
	
	/**
	 * 오픈이력서 조회기업목록
	 */
	/*@ApiOperation(value = "이력서를 본 기업목록")
	@RequestMapping("/readCompany")
	public List<Companys> readCompany(@ApiParam("목록을 볼 유저정보")Users user) throws IOException, NotFoundException{
		List<Companys> comList = resumeService.readCompany(user);
		
		return comList;
	}*/
	
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
