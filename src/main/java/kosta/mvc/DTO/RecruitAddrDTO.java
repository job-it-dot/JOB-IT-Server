package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitAddrDTO {
	
	private Long recruitAddrId;
	
	private CompanyAddrDTO companyAddr;
	
	private RecruitFormDTO recruitForm;
}
