package kosta.mvc.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAddr {
	private int companyAddrId;
	private Companys company;
	private String companyAddrName;
	private String companyAddrDetail;
	private double companyAddrCoordX;
	private double companyAddrCoordY;
	
	private List<RecruitAddr> recruitAddrList;
	
}
