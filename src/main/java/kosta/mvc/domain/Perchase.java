package kosta.mvc.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.PerchaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Perchase {
	
	public Perchase(PerchaseDTO perchaseDTO){
		this.perchaseId = perchaseDTO.getPerchaseId();
		this.perchasePrice = perchaseDTO.getPerchasePrice();
		this.perchaseStatus = perchaseDTO.getPerchaseStatus();
		this.perchaseTime = perchaseDTO.getPerchaseTime();
		this.product = new Product(perchaseDTO.getProduct());
		this.company = new Companys(perchaseDTO.getCompany());
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long perchaseId;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private Timestamp perchaseTime;
	private int perchasePrice;
	private int perchaseStatus;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Companys company;
}
