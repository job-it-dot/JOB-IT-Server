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
	
	private String applyEmail;
	private String applyPhone;
	private int applyStatus;
	
	private RecruitDTO recruit;
}
