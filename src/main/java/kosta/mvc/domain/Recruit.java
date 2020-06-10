package kosta.mvc.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruit {
	private int recruitId;
	private Companys company;
	private Positions position;
	private String recruitDetail;
	private Date recruitEndDate;
}
