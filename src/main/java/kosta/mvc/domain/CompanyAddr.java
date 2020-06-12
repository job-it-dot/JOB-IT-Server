package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
