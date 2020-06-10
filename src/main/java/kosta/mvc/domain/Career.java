package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Career {
	private int careerId;
	private Resume resume;
	private String careerCompanyName;
	private String careerPosition;
	private String careerStartDate;
	private String careerEndDate;
	private int careerStatus;
}
