package com.ktr.sb.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ktr.sb.custom.ids.CustomProductID;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_seq")
    @GenericGenerator(
        name = "prod_id_seq", 
        strategy = "com.ktr.sb.custom.ids.CustomProductID", 
        parameters = {
            @Parameter(name = CustomProductID.INCREMENT_PARAM, value = "50"),
            @Parameter(name = CustomProductID.VALUE_PREFIX_PARAMETER, value = "06F91F00"),
            @Parameter(name = CustomProductID.NUMBER_FORMAT_PARAMETER, value = "%02d")})
	private String prodId;
	private String prodCategory;
	private String prodName;
	
	public Product() {		
	}
		
	public Product(String prodId, String prodCategory, String prodName) {
		this.prodId = prodId;
		this.prodCategory = prodCategory;
		this.prodName = prodName;
	}

	public String getProdId() {
		return prodId;
	}
	public void setProdid(String prodId) {
		this.prodId = prodId;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	

}
