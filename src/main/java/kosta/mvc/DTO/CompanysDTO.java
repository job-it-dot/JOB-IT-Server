package kosta.mvc.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanysDTO{
	
	private Long companyId;
	
	private MembersDTO member;
	
	private CompanyTypeDTO companyType;
	private String companyName;
	private String companyDetail;
	private int companyEmployeeCount;
	private Date companyPremiumAt;
	private int companyPoints;
	

}
