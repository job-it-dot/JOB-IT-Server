package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.RecruitForm;
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
	private RecruitRepository recruitRepository;

	@Autowired
	private RecruitPlanRepository recruitPlanRepository;

	@Autowired
	private ApplyRepository applyRepository;

	@Autowired
	private PerchaseRepository perchaseRepository;

	@Autowired
	private ResumeRepository resumeRepository;

	private PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public Companys selectCompanyByMemberId(Long memberId) throws IOException, NotFoundException {
		return companysRepository.findByMemberId(memberId);
	};

	@Override
	public int duplicateEmail(String memberEmail) throws IOException {
		int result = 0;

		Members member = membersRepository.findByMemberEmail(memberEmail);

			if (member != null && member.getMemberStatus() != 4 && member.getMemberStatus() != 5)
				result = 1;

		return result;
	}

	@Transactional
	@Override
	public int insertCompany(Companys company) throws IOException {
		int result = 0;

		if (company != null) {
			Members member = company.getMember();
			member.setMemberPassword(encoder.encode(member.getMemberPassword()));
			member.setMemberStatus(2);
			membersRepository.save(member);
			company.setMember(member);
			companysRepository.save(company);
			result = 1;
		}

		return result;
	}

//	@Override
//	public Long login(String memberEmail, String memberPassword) throws IOException, NotFoundException {
//		Long companyId = 0L;
//		Members member = null;
//		
//		List<Members> members = membersRepository.findByMemberEmail(memberEmail);
//		
//		for(Members mem : members) {
//			if(mem.getMemberStatus() == 2) {
//				member = mem;
//			}
//		}
//		
////		Companys company = companysRepository.findByMemberId(member.getMemberId());
//		
////		if(checkPassword(companyId, memberPassword) == 1) companyId = company.getCompanyId();
//			
//		return companyId;
//	}

	@Override
	public Companys selectCompanyById(Long companyId) throws IOException {
		return companysRepository.findById(companyId).orElse(null);
	}

	@Override
	public int checkPassword(Long companyId, String memberPassword) throws IOException, NotFoundException {

		int result = 0;
		Companys dbCompany = companysRepository.findById(companyId).orElse(null);

		if (dbCompany != null) {
			Members dbMember = membersRepository.findById(dbCompany.getMember().getMemberId()).orElse(null);

			if (encoder.matches(memberPassword, dbMember.getMemberPassword()))
				result = 1;
		}

		return result;
	}

	@Override
	public int updateCompany(Companys company) throws IOException, NotFoundException {

		int result = 0;
		Companys dbCompany = companysRepository.findById(company.getCompanyId()).orElse(null);

		if (dbCompany != null) {
			if (company.getCompanyDetail() != null) {
				dbCompany.setCompanyDetail(company.getCompanyDetail());
			}
			if (company.getCompanyEmployeeCount() != 0) {
				dbCompany.setCompanyEmployeeCount(company.getCompanyEmployeeCount());
			}
			if (company.getCompanyName() != null) {
				dbCompany.setCompanyName(company.getCompanyName());
			}
			if (company.getCompanyType() != null) {
				dbCompany.setCompanyType(company.getCompanyType());
			}
			if (company.getMember().getMemberPassword() != null) {
				dbCompany.getMember().setMemberPassword(company.getMember().getMemberPassword());
			}
			companysRepository.save(dbCompany);
			result = 1;
		}

		return result;
	}

	@Override
	public List<RecruitForm> selectRecruitByCompanyId(Long companyId) throws IOException {
		return companysRepository.findById(companyId).orElse(null).getRecruitForms();
	}

	@Override
	public Recruit selectRecruitById(Long recruitId) throws IOException, NotFoundException {

		return recruitRepository.findById(recruitId).orElse(null);
	}

	@Override
	public int insertRecruit(Recruit recruit) throws IOException {

		int result = 0;
		Recruit saveRecruit = recruitRepository.save(recruit);
		if (saveRecruit != null)
			result = 1;

		return result;
	}

	@Override
	public int updateRecruit(Recruit recruit) throws IOException, NotFoundException {

		int result = 0;
		Recruit dbRecruit = recruitRepository.findById(recruit.getRecruitId()).orElse(null);

		if (dbRecruit != null) {
			if (recruit.getPosition() != null)
				dbRecruit.setPosition(recruit.getPosition());
			if (recruit.getRecruitForm().getRecruitCareer() != 0)
				dbRecruit.getRecruitForm().setRecruitCareer(recruit.getRecruitForm().getRecruitCareer());
			if (recruit.getRecruitForm().getRecruitDetail() != null)
				dbRecruit.getRecruitForm().setRecruitDetail(recruit.getRecruitForm().getRecruitDetail());
			if (recruit.getRecruitForm().getRecruitEndDate() != null)
				dbRecruit.getRecruitForm().setRecruitEndDate(recruit.getRecruitForm().getRecruitEndDate());
			if (recruit.getRecruitForm().getRecruitSalary() != 0)
				dbRecruit.getRecruitForm().setRecruitSalary(recruit.getRecruitForm().getRecruitSalary());
			if (recruit.getRecruitForm().getRequiredEdu() != null)
				dbRecruit.getRecruitForm().setRequiredEdu(recruit.getRecruitForm().getRequiredEdu());
			recruitRepository.save(dbRecruit);
			result = 1;
		}

		return result;
	}

	@Override
	public int unpostRecruit(Long recruitId) throws IOException, NotFoundException {

		int result = 0;
		Recruit dbRecruit = recruitRepository.findById(recruitId).orElse(null);

		if (dbRecruit != null) {
			dbRecruit.getRecruitForm().setRecruitStatus(2);
			recruitRepository.save(dbRecruit);
			result = 1;
		}

		return result;
	}

	@Override
	public List<RecruitPlan> selectRecruitPlanByCompanyId(Long companyId) throws IOException {
		return companysRepository.findById(companyId).orElse(null).getRecruitPlans();
	}

	@Override
	public RecruitPlan selectRecruitPlanById(Long recruitPlanId) throws IOException, NotFoundException {
		return recruitPlanRepository.findById(recruitPlanId).orElse(null);
	}

	@Override
	public int insertRecruitPlan(RecruitPlan recruitPlan) throws IOException {

		int result = 0;
		RecruitPlan saveRecruitPlan = recruitPlanRepository.save(recruitPlan);
		if (saveRecruitPlan != null)
			result = 1;

		return result;
	}

	@Override
	public int updateRecruitPlan(RecruitPlan recruitPlan) throws IOException, NotFoundException {

		int result = 0;
		RecruitPlan dbRecruitPlan = recruitPlanRepository.findById(recruitPlan.getRecruitPlanId()).orElse(null);

		if (dbRecruitPlan != null) {
			if (recruitPlan.getPosition() != null) {
				dbRecruitPlan.setPosition(recruitPlan.getPosition());
			}
			if (recruitPlan.getRecruitPlanDetail() != null) {
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
		RecruitPlan dbRecruitPlan = recruitPlanRepository.findById(recruitPlanId).orElse(null);

		if (dbRecruitPlan != null && dbRecruitPlan.getCompany().getCompanyId() == companyId) {
			recruitPlanRepository.delete(dbRecruitPlan);
			result = 1;
		}

		return result;
	}

	@Override
	public List<Apply> selectApplyByRecruitId(Long recruitId) throws IOException {
		return recruitRepository.findById(recruitId).orElse(null).getApplys();
	}

	@Override
	public Apply selectApplyById(Long applyId) throws IOException, NotFoundException {
		return applyRepository.findById(applyId).orElse(null);
	}

	@Override
	public int insertPerchase(Perchase perchase) throws IOException {

		int result = 0;
		Perchase savePerchase = perchaseRepository.save(perchase);
		if (savePerchase != null)
			result = 1;

		return result;
	}

	@Override
	public int updatePerchase(Long perchaseId) throws IOException, NotFoundException {

		int result = 0;
		Perchase dbPerchase = perchaseRepository.findById(perchaseId).orElse(null);

		if (dbPerchase != null) {
			dbPerchase.setPerchaseStatus(2);
			perchaseRepository.save(dbPerchase);
			result = 1;
		}

		return result;
	}

	@Override
	public List<Resume> selectOpenResumeAll(Long companyId) throws IOException {
		return resumeRepository.findByResumeStatus(1);
	}

	@Override
	public Resume selectOpenResumeByResumeId(Long companyId, Long resumeId) throws IOException, NotFoundException {
		return resumeRepository.findByResumeIdAndResumeStatus(resumeId, 1);
	}

}