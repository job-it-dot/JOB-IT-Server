package kosta.mvc.domain;

import java.util.List;

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
	
	private List<Edu> eduList;
	private List<License> licenseList;
	private List<Career> careerList;
	private List<Lang> langList;
	private List<Link> linkList;
	private List<UserSkill> userSkillList;
	private List<Apply> applyList;
}
