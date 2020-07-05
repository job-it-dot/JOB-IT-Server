package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitDTO {
	
	private Long recruitId;
	private PositionsDTO position;
	private RecruitFormDTO recruitForm;
}
