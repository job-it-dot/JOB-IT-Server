package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResumeReadDTO {
	
	private Long resumeReadId;
	
	private ResumeDTO resume;
	
	private CompanysDTO company;
	
	private UsersDTO user;
	
	private boolean isNew;

}
