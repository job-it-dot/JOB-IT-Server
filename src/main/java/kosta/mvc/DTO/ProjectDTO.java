package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
	
	private Long projectId;
	private String projectName;
	private String projectStartAt;
	private String projectEndAt;
	private String projectContent;
	
	private CareerDTO career;
}
