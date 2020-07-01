package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LangDTO {
	
	private Long langId;
	
	private LangClassDTO langClass;
	
	private LangLevelDTO langLevel;
	
	private ResumeDTO resume;
	
}
