package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSkillDTO {
	
	private Long userSkillId;
	
	private SkillsDTO skill;
	
	private ResumeDTO resume;
}
