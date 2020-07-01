package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kosta.mvc.DTO.PositionsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Positions {
	
	Positions(PositionsDTO positionsDTO){
		this.positionId = positionsDTO.getPositionId();
		this.positionName = positionsDTO.getPositionName();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long positionId;
	private String positionName;
}
