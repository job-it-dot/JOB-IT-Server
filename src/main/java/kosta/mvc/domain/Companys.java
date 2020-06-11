package kosta.mvc.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Companys extends Members{
	private CompanyType companyType;
	private String companyName;
	private String companyDetail;
	private int companyEmployeeCount;
	private Date companyPremiumDate;
	private int companyPoints;
	
	private List<CompanyImage> companyImageList;
	private List<CompanyAddr> companyAddrList;
	private List<Recruit> recruitList;
	private List<RecruitPlan> recruitPlanList;
	private List<Follow> followList;
	private List<Perchase> perchaseList;
}
