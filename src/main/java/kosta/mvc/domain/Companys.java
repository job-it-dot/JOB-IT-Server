package kosta.mvc.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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
public class Companys extends Members{
	
	@ManyToOne
	private CompanyType companyType;
	private String companyName;
	private String companyDetail;
	private int companyEmployeeCount;
	private Date companyPremiumDate;
	private int companyPoints;
	
	@OneToMany
	private List<CompanyImage> companyImageList;
	
	@OneToMany
	private List<CompanyAddr> companyAddrList;
	
	@OneToMany
	private List<Recruit> recruitList;
	
	@OneToMany
	private List<RecruitPlan> recruitPlanList;
	
	@OneToMany
	private List<Perchase> perchaseList;
}
