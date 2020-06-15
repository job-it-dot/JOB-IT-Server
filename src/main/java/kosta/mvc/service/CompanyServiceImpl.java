package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.RecruitPlan;
import kosta.mvc.domain.Resume;
import kosta.mvc.repository.ApplyRepository;
import kosta.mvc.repository.CompanysRepository;
import kosta.mvc.repository.PerchaseRepository;
import kosta.mvc.repository.RecruitPlanRepository;
import kosta.mvc.repository.RecruitRepository;
import kosta.mvc.repository.ResumeRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanysRepository companysRepository;
	
	@Autowired
	private RecruitRepository recruitRepository;

	@Autowired
	private RecruitPlanRepository recruitPlanRepository;
	
	@Autowired
	private ApplyRepository applyRepository;
	
	@Autowired
	private PerchaseRepository perchaseRepository;
	
	@Autowired
	private ResumeRepository resumeRepository;

	@Override
	public Companys selectCompanyById(Long companyId) throws IOException {
		return companysRepository.findByCompanyId(companyId);
	}

	@Override
	public int updateCompany(Companys company) throws IOException, NotFoundException {
		
		int result = 0;
		Companys dbCompany = companysRepository.findByCompanyId(company.getCompanyId());
		
		if(dbCompany != null) {
			//수정할 항목 어디어디인지...?
			dbCompany.setCompanyEmployeeCount(company.getCompanyEmployeeCount());
			companysRepository.save(dbCompany);
			result = 1;
		}
		
		return result;
	}

	@Override
	public List<Recruit> selectRecruitByCompanyId(Long companyId) throws IOException {
		return recruitRepository.findByCompanyId(companyId);
	}

	@Override
	public Recruit selectRecruitById(Long recruitId) throws IOException, NotFoundException {
		return recruitRepository.findByRecruitId(recruitId);
	}

	@Override
	public int insertRecruit(Recruit recruit) throws IOException {
		
		int result = 0;
		Recruit saveRecruit = recruitRepository.save(recruit);
		if(saveRecruit != null) result = 1;
		
		return result;
	}

	@Override
	public int updateRecruit(Recruit recruit) throws IOException, NotFoundException {
		
		int result = 0;
		Recruit dbRecruit = recruitRepository.findByRecruitId(recruit.getRecruitId());
		
		if(dbRecruit != null) {
			//수정할 항목 어디어디인지...?
			dbRecruit.setPosition(recruit.getPosition());
			recruitRepository.save(dbRecruit);
			result = 1;
		}
		
		return result;
	}

	@Override
	public int deleteRecruit(Long companyId, Long recruitId) throws IOException {

		int result = 0;
		
		return result;
	}

	@Override
	public List<RecruitPlan> selectRecruitPlanByCompanyId(Long companyId) throws IOException {
		return recruitPlanRepository.findByCompanyId(companyId);
	}

	@Override
	public RecruitPlan selectRecruitPlanById(Long recruitPlanId) throws IOException, NotFoundException {
		return recruitPlanRepository.findByRecruitPlanId(recruitPlanId);
	}

	@Override
	public int insertRecruitPlan(RecruitPlan recruitPlan) throws IOException {

		int result = 0;
		RecruitPlan saveRecruitPlan = recruitPlanRepository.save(recruitPlan);
		if(saveRecruitPlan != null) result = 1;
		
		return result;
	}

	@Override
	public int updateRecruitPlan(RecruitPlan recruitPlan) throws IOException, NotFoundException {

		int result = 0;
		RecruitPlan dbRecruitPlan = recruitPlanRepository.findByRecruitPlanId(recruitPlan.getRecruitPlanId());
		
		if(dbRecruitPlan != null) {
			if(recruitPlan.getPosition() != null) {
				dbRecruitPlan.setPosition(recruitPlan.getPosition());
			}
			if(recruitPlan.getRecruitPlanDetail() != null) {
				dbRecruitPlan.setRecruitPlanDetail(recruitPlan.getRecruitPlanDetail());
			}
			recruitPlanRepository.save(dbRecruitPlan);
			result = 1;
		}
		
		return result;
	}

	@Override
	public int deleteRecruitPlan(Long companyId, Long recruitPlanId) throws IOException, NotFoundException {

		int result = 0;
		RecruitPlan dbRecruitPlan = recruitPlanRepository.findByRecruitPlanId(recruitPlanId);
		
		if(dbRecruitPlan != null && dbRecruitPlan.getCompany().getCompanyId() == companyId) {
			recruitPlanRepository.delete(dbRecruitPlan);
			result = 1;
		}
		
		return result;
	}

	@Override
	public List<Apply> selectApplyByRecruitId(Long recruitId) throws IOException {
		return applyRepository.findByRecruitId(recruitId);
	}

	@Override
	public Apply selectApplyById(Long applyId) throws IOException, NotFoundException {
		return applyRepository.findByApplyId(applyId);
	}

	@Override
	public int insertPerchase(Perchase perchase) throws IOException {

		int result = 0;
		Perchase savePerchase = perchaseRepository.save(perchase);
		if(savePerchase != null) result = 1;
		
		return result;
	}

	@Override
	public int updatePerchase(Long perchaseId) throws IOException, NotFoundException {

		int result = 0;
		Perchase dbPerchase = perchaseRepository.findByPerchaseId(perchaseId);
		
		if(dbPerchase != null) {
			dbPerchase.setPerchaseStatus(2);
			perchaseRepository.save(dbPerchase);
			result = 1;
		}
		
		return result;
	}

	@Override
	public List<Resume> selectOpenResumeAll() throws IOException {
		return resumeRepository.findByResumeStatus(1);
	}

	@Override
	public Resume selectOpenResumeByResumeId(Long resumeId) throws IOException, NotFoundException {
		return resumeRepository.findByResumeIdAndResumeStatus(resumeId, 1);
	}

}
