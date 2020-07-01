package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.CompanyImageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyImage {
	
	public CompanyImage(CompanyImageDTO companyImageDTO){
		this.companyImgId = companyImageDTO.getCompanyImgId();
		this.companyImgName = companyImageDTO.getCompanyImgName();
		this.company = new Companys(companyImageDTO.getCompany());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyImgId;
	private String companyImgName;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Companys company;
}
