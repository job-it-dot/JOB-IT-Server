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
public class Perchase {
	private int perchaseId;
	private Companys company;
	private Product product;
	private Timestamp perchaseTime;
	private int perchasePrice;
	private int perchaseStatus;
}
