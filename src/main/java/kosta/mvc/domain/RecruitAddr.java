package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitAddr {
	private int recruitAddrId;
	private Recruit recruit;
	private CompanyAddr companyAddr;
}
