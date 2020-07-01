package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitPlanDTO {
	private Long recruitPlanId;
	
	private CompanysDTO company;
	
	private PositionsDTO position;
	
	private String recruitPlanDetail;
}
