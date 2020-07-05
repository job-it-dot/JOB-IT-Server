package kosta.mvc.DTO;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResultDTO {
	
	private String memberType;
	private Users user;
	private Companys company;

}
