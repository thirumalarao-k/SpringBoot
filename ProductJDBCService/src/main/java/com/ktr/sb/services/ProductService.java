package com.ktr.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktr.sb.db.daos.ProductDAO;
import com.ktr.sb.pojos.Product;

@Service
public class ProductService {

@Autowired
private ProductDAO proDao;

	public Product getProduct(String prodId){
		return proDao.getProduct(prodId);
	
	}
	
	public List<Product> createProduct(String prodId, String prodCategory, String prodName){
		return proDao.createProduct(prodId, prodCategory, prodName);
	}
	
	public List<Product> getAllProducts(){
		return proDao.getAllProducts();
	}
}
