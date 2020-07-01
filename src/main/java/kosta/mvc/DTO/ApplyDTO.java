package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplyDTO {

	private Long applyId;
	
	private ResumeDTO resume;
	
	private int applyStatus;
	
	private RecruitDTO recruit;
}
