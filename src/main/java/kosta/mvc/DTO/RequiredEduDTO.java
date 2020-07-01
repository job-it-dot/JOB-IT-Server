package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequiredEduDTO {
	
	private Long requiredEduId;
	private int reqEduGrade;
	private String reqEduName;
}
