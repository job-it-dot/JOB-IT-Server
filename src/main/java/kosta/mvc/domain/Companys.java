package kosta.mvc.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Companys extends Members{
	private String companyName;
	private String companyDetail;
	private int companyEmployeeCount;
	private Date companyPremiumDate;
	private int companyPoints;
}
