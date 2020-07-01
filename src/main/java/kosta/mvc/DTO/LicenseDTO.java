package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseDTO {
	
	private Long licenseId;
	private String licenseAt;
	private String licenseName;
	private String licenseContent;
	
	private ResumeDTO resume;
}
