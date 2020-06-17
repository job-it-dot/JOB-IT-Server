package kosta.mvc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="position_id")
	private Positions position;
	
	@ManyToOne
	@JoinColumn(name="required_edu_id")
	private RequiredEdu requiredEdu;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Companys company;
	
	private int recruitCareer;
	private String recruitDetail;
	private Date recruitEndDate;
	private int recruitSalary;
	private int recruitStatus;
	
	@OneToMany(mappedBy = "recruit")
	private List<Apply> applys = new ArrayList<Apply>();
	
	@OneToMany(mappedBy = "recruit")
	private List<RequiredSkill> requiredSkills = new ArrayList<RequiredSkill>();
}
