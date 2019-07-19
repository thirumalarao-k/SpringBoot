package com.ktr.sb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktr.sb.db.daos.ProductDAO;
import com.ktr.sb.excephandling.ProductNotfoundException;
import com.ktr.sb.pojos.Product;

@Service
public class ProductService {

@Autowired
private ProductDAO proDao;

	public Product getProduct(String prodId){
		
		Optional<Product> prod = proDao.findById(prodId);		
		if (!prod.isPresent()){
			throw new ProductNotfoundException(prodId);
		}
		return prod.get();
	}
	
	public List<Product> createProduct(Product prod){
		proDao.save(prod);
		return getAllProducts();
	}
	
	public List<Product> getAllProducts(){
		return proDao.findAll();
	}
}
