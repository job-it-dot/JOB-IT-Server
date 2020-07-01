package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CareerDTO {
	
	private Long careerId;
	private String careerCompanyName;
	private String careerPosition;
	private String careerStartAt;
	private String careerEndAt;
	private int careerStatus;
	
	private ResumeDTO resume;
}
