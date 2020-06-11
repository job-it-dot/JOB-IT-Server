package kosta.mvc.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Members {
	private int memberId;
	private int kakaoId;
	private String memberEmail;
	private String memberPassword;
	private String memberRole;
	private int memberStatus;
	private Timestamp memberJoinDate;
}
