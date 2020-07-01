package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.RecruitAddrDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitAddr {
	
	public RecruitAddr(RecruitAddrDTO recruitAddrDTO){
		this.recruitAddrId = recruitAddrDTO.getRecruitAddrId();
		this.companyAddr = new CompanyAddr(recruitAddrDTO.getCompanyAddr());
		this.recruit = new Recruit(recruitAddrDTO.getRecruit());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruitAddrId;
	
	@ManyToOne
	@JoinColumn(name="company_addr_id")
	private CompanyAddr companyAddr;
	
	@ManyToOne
	@JoinColumn(name="recruit_id")
	private Recruit recruit;
}
