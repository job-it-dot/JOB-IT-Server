package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kosta.mvc.DTO.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	public Product(ProductDTO productDTO){
		this.productId = productDTO.getProductId();
		this.productName = productDTO.getProductName();
		this.productPrice = productDTO.getProductPrice();
		this.productStatus = productDTO.getProductStatus();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private int productPrice;
	private int productStatus;
}
