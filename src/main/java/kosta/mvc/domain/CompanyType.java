package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kosta.mvc.DTO.CompanyTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyType {
	
	CompanyType(CompanyTypeDTO companyTypeDTO){
		this.companyTypeId = companyTypeDTO.getCompanyTypeId();
		this.companyTypeName = companyTypeDTO.getCompanyTypeName();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyTypeId;
	private String companyTypeName;
}
