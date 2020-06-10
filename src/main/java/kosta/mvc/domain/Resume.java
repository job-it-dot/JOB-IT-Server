package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
	private int resumeId;
	private Users user;
	private String resumeName;
	private String resumePhone;
	private String resumeContent;
	private int resumeStatus;
}
