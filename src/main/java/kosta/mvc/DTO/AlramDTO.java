package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlramDTO {
	
	private Long alramId;

	private RecruitDTO recruit;
	
	private boolean isNew;

	private UsersDTO user;
}
