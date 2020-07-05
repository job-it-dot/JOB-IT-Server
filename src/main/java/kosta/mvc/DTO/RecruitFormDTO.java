package kosta.mvc.DTO;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.RequiredEdu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitFormDTO {
	
	private Long recruitFormId;
	
	private String recruitName;
	private int recruitCareer;
	private String recruitDetail;
	private Date recruitEndDate;
	private int recruitSalary;
	private int recruitStatus;
	
	private RequiredEduDTO requiredEdu;
	
	private CompanysDTO company;
	
}
