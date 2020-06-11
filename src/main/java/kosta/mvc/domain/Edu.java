package kosta.mvc.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Edu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eduId;
	private Resume resume;
	private String eduJoinDate;
	private String eduGraduateDate;
	private int eduStatus;
	private String eduName;
	private String eduDetail;
}
