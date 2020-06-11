package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class License {
	private int licenseId;
	private Resume resume;
	private String licenseDate;
	private String licenseName;
	private String licenseContent;
}
