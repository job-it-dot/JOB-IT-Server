package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.CompanyAddrDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAddr {
	
	public CompanyAddr(CompanyAddrDTO companyAddrDTO){
		this.companyAddrId = companyAddrDTO.getCompanyAddrId();
		this.companyAddrName = companyAddrDTO.getCompanyAddrName();
		this.companyAddrDetail = companyAddrDTO.getCompanyAddrDetail();
		this.companyAddrCoordX = companyAddrDTO.getCompanyAddrCoordX();
		this.companyAddrCoordY = companyAddrDTO.getCompanyAddrCoordY();
		this.company = new Companys(companyAddrDTO.getCompany());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyAddrId;
	private String companyAddrName;
	private String companyAddrDetail;
	private double companyAddrCoordX;
	private double companyAddrCoordY;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Companys company;
	
}
