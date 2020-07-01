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

import kosta.mvc.DTO.RecruitDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruit {
	
	Recruit(RecruitDTO recruitDTO){
		this.recruitId = recruitDTO.getRecruitId();
		this.recruitCareer = recruitDTO.getRecruitCareer();
		this.recruitDetail = recruitDTO.getRecruitDetail();
		this.recruitEndDate = recruitDTO.getRecruitEndDate();
		this.recruitSalary = recruitDTO.getRecruitSalary();
		this.recruitStatus = recruitDTO.getRecruitStatus();
		this.position = new Positions(recruitDTO.getPosition());
		this.requiredEdu = new RequiredEdu(recruitDTO.getRequiredEdu());
		this.company = new Companys(recruitDTO.getCompany());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruitId;
	
	private int recruitCareer;
	private String recruitDetail;
	private Date recruitEndDate;
	private int recruitSalary;
	private int recruitStatus;
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private Positions position;
	
	@ManyToOne
	@JoinColumn(name="required_edu_id")
	private RequiredEdu requiredEdu;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Companys company;
	
	@OneToMany(mappedBy = "recruit", fetch = FetchType.LAZY)
	private List<Apply> applys = new ArrayList<Apply>();
	
	@OneToMany(mappedBy = "recruit", fetch = FetchType.LAZY)
	private List<RequiredSkill> requiredSkills = new ArrayList<RequiredSkill>();
	
	@OneToOne(mappedBy = "recruit", fetch = FetchType.LAZY)
	private RecruitAddr recruitAddr;
}
