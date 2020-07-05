package kosta.mvc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import kosta.mvc.DTO.RecruitFormDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitForm {
	
	RecruitForm(RecruitFormDTO recruitFormDTO){
		this.recruitFormId = recruitFormDTO.getRecruitFormId();
		this.recruitCareer = recruitFormDTO.getRecruitCareer();
		this.recruitDetail = recruitFormDTO.getRecruitDetail();
		this.recruitEndDate = recruitFormDTO.getRecruitEndDate();
		this.recruitSalary = recruitFormDTO.getRecruitSalary();
		this.recruitStatus = recruitFormDTO.getRecruitStatus();
		this.requiredEdu = new RequiredEdu(recruitFormDTO.getRequiredEdu());
		this.company = new Companys(recruitFormDTO.getCompany());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruitFormId;
	
	private int recruitCareer;
	private String recruitDetail;
	private Date recruitEndDate;
	private int recruitSalary;
	private int recruitStatus;
	
	@ManyToOne
	@JoinColumn(name="required_edu_id")
	private RequiredEdu requiredEdu;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Companys company;
	
	@OneToMany(mappedBy = "recruitForm", fetch = FetchType.LAZY)
	private List<Recruit> recruits = new ArrayList<Recruit>();
	
	@OneToMany(mappedBy = "recruitForm", fetch = FetchType.LAZY)
	private List<RequiredSkill> requiredSkills = new ArrayList<RequiredSkill>();
	
	@OneToOne(mappedBy = "recruitForm", fetch = FetchType.LAZY)
	private RecruitAddr recruitAddr;

}
