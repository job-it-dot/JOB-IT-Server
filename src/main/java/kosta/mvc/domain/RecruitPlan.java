package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitPlan {
	private int recruitPlanId;
	private Companys company;
	private Positions position;
	private String recruitPlanDetail;
}
