package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.RecruitPlan;
import kosta.mvc.domain.Resume;
import kosta.mvc.repository.ApplyRepository;
import kosta.mvc.repository.CompanysRepository;
import kosta.mvc.repository.MembersRepository;
import kosta.mvc.repository.PerchaseRepository;
import kosta.mvc.repository.RecruitPlanRepository;
import kosta.mvc.repository.RecruitRepository;
import kosta.mvc.repository.ResumeRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanysRepository companysRepository;
	
	@Autowired
	private MembersRepository membersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	public int checkPassword(Long companyId, String password) throws IOException, NotFoundException{
		
		int result = 0;
		Companys dbCompany = companysRepository.findByCompanyId(companyId);
		
		if(dbCompany != null) {
			Members dbMember = membersRepository.findByMemberId(dbCompany.getMember().getMemberId());
			
			if(passwordEncoder.matches(password, dbMember.getMemberPassword())) result = 1;
		}
		
		return result;
	}

	@Override
	public int updateCompany(Companys company) throws IOException, NotFoundException {
		
		int result = 0;
		Companys dbCompany = companysRepository.findByCompanyId(company.getCompanyId());
		
		if(dbCompany != null) {
			if(company.getCompanyDetail() != null) {
				dbCompany.setCompanyDetail(company.getCompanyDetail());
			}
			if(company.getCompanyEmployeeCount() != 0) {
				dbCompany.setCompanyEmployeeCount(company.getCompanyEmployeeCount());
			}
			if(company.getCompanyName() != null) {
				dbCompany.setCompanyName(company.getCompanyName());
			}
			if(company.getCompanyType() != null) {
				dbCompany.setCompanyType(company.getCompanyType());
			}
			if(company.getMember().getMemberPassword() != null) {
				dbCompany.getMember().setMemberPassword(company.getMember().getMemberPassword());
			}
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
			if(recruit.getPosition() != null) dbRecruit.setPosition(recruit.getPosition());
			if(recruit.getRecruitCareer() != 0) dbRecruit.setRecruitCareer(recruit.getRecruitCareer());
			if(recruit.getRecruitDetail() != null) dbRecruit.setRecruitDetail(recruit.getRecruitDetail());
			if(recruit.getRecruitEndDate() != null) dbRecruit.setRecruitEndDate(recruit.getRecruitEndDate());
			if(recruit.getRecruitSalary() != 0) dbRecruit.setRecruitSalary(recruit.getRecruitSalary());
			if(recruit.getRequiredEdu() != null) dbRecruit.setRequiredEdu(recruit.getRequiredEdu());
			recruitRepository.save(dbRecruit);
			result = 1;
		}
		
		return result;
	}

	@Override
	public int unpostRecruit(Long recruitId) throws IOException {

		int result = 0;
		Recruit dbRecruit = recruitRepository.findByRecruitId(recruitId);
		
		if(dbRecruit != null) {
			dbRecruit.setRecruitStatus(2);
			recruitRepository.save(dbRecruit);
			result = 1;
		}
		
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
