package kosta.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lang {
	private int langId;
	private Resume resume;
	private LangClass langClass;
	private LangLevel langLevel;
}
