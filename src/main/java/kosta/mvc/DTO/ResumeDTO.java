package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDTO {
	
	private Long resumeId;
	
	private UsersDTO user;
	
	private String resumeName;
	private String resumePhone;
	private String resumeContent;
	private int resumeStatus;
	
	
}
