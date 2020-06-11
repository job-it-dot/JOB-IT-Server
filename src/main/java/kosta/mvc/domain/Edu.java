package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Edu {
	private int eduId;
	private Resume resume;
	private String eduJoinDate;
	private String eduGraduateDate;
	private int eduStatus;
	private String eduName;
	private String eduDetail;
}
