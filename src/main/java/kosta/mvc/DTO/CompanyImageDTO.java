package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyImageDTO {
	
	private Long companyImgId;
	private String companyImgName;
	
	private CompanysDTO company;
}
