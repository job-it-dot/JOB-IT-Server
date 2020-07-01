package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LangLicenseDTO {
	
	private Long langLicenseId;
	private String langLicenseName;
	private String langLicenseAt;
	private String langLicenseLevel;
	
	private LangDTO lang;
}
