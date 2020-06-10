package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LangLicense {
	private int langLicenseId;
	private Lang lang;
	private String langLicenseName;
	private String langLicenseDate;
	private String langLicenseLevel;
}
