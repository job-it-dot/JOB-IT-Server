package kosta.mvc.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerchaseDTO {
	
	private Long perchaseId;
	
	private ProductDTO product;
	private Timestamp perchaseTime;
	private int perchasePrice;
	private int perchaseStatus;
	
	private CompanysDTO company;
}
