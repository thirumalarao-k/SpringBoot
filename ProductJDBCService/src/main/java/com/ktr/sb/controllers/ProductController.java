package com.ktr.sb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ktr.sb.pojos.Product;
import com.ktr.sb.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService prodServ;
	
	@GetMapping("/getproducts")
	public List<Product> getAllProducts(){
		return prodServ.getAllProducts();
		
	}
	
	 @GetMapping("/getproduct/{prodId}")
	public Product getProduct(@PathVariable("prodId") String prodId ){
		return prodServ.getProduct(prodId);
		
	}
	
	@PostMapping("/createproduct")
	public List<Product> createProducts(@RequestBody  Product prod ){
		return prodServ.createProduct(prod.getProdId(),prod.getProdCategory(),prod.getProdName());
		
	}
}
