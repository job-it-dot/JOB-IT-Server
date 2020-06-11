package kosta.mvc.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruitId;
	private Companys company;
	private Positions position;
	private RequiredEdu requiredEdu;
	private int recruitCareer;
	private String recruitDetail;
	private Date recruitEndDate;
	private int recruitSalary;
	
	private List<RecruitAddr> recruitAddrList;
	private List<RequiredSkills> requiredSkillsList;
	private List<Scrap> scrapList;
	private List<Alram> alramList;
	private List<Apply> applyList;
}
