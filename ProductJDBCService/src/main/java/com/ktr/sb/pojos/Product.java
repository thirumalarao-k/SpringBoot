package com.ktr.sb.pojos;

public class Product {
	
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
