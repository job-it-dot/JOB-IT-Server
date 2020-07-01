package kosta.mvc.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitDTO {
	
	private Long recruitId;
	
	private PositionsDTO position;
	
	private RequiredEduDTO requiredEdu;
	
	private CompanysDTO company;
	
	private int recruitCareer;
	private String recruitDetail;
	private Date recruitEndDate;
	private int recruitSalary;
	private int recruitStatus;
}
