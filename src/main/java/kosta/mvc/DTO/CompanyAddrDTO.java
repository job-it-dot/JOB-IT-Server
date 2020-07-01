package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAddrDTO {
	
	private Long companyAddrId;
	private String companyAddrName;
	private String companyAddrDetail;
	private double companyAddrCoordX;
	private double companyAddrCoordY;
	
	private CompanysDTO company;
	
}
