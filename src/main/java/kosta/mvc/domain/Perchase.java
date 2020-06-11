package kosta.mvc.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Perchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long perchaseId;
	
	@ManyToOne
	private Product product;
	private Timestamp perchaseTime;
	private int perchasePrice;
	private int perchaseStatus;
}
