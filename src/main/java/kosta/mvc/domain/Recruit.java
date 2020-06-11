package kosta.mvc.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruitId;
	
	@ManyToOne
	private Positions position;
	
	@ManyToOne
	private RequiredEdu requiredEdu;
	
	private int recruitCareer;
	private String recruitDetail;
	private Date recruitEndDate;
	private int recruitSalary;
	
	@OneToMany
	private List<RecruitAddr> recruitAddrList;
	
	@OneToMany
	private List<RequiredSkills> requiredSkillsList;
	
	@OneToMany
	private List<Apply> applyList;
}
