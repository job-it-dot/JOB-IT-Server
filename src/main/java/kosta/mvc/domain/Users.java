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
public class Users extends Members {
	private String userName;
	private String userPhone;
	
	private List<Resume> resumeList;
	private List<Follow> followList;
	private List<Scrap> scrapList;
	private List<Alram> alramList;
}
