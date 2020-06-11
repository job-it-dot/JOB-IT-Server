package kosta.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users extends Members {
	private String userName;
	private String userPhone;
	
	@OneToMany
	private List<Resume> resumeList;
	
	@OneToMany
	private List<Follow> followList;
	
	@OneToMany
	private List<Scrap> scrapList;
	
	@OneToMany
	private List<Alram> alramList;
}
