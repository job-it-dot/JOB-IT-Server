package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EduDTO {
	
	private Long eduId;
	private String eduJoinAt;
	private String eduGraduateAt;
	private int eduStatus;
	private String eduName;
	private String eduDetail;
	
	private ResumeDTO resume;
}
