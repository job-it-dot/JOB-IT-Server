package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	private int projectId;
	private Career career;
	private String projectName;
	private String projectStartDate;
	private String projectEndDate;
	private String projectContent;
}
