package com.ktr.sb.db.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktr.sb.pojos.Product;

@Repository
public class ProductDAO {
	
	@Qualifier("jdbcProductService")
	@Autowired
	private JdbcTemplate jdbcProdTemplate;
	
	public Product getProduct(String prodId){
		
		/* String selQuery = "SELECT prodId, prodCategory, prodName  FROM Products where prodId = '"+prodId+"'";
		
		Product prods = (Product) jdbcProdTemplate.query(selQuery, 
				(rs, rowNum) -> new Product(rs.getString("prodId"),
                        rs.getString("prodCategory"), rs.getString("prodName"))
        ); */
		String selQuery = "SELECT prodId, prodCategory, prodName  FROM Products where prodId = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		Product prods = jdbcProdTemplate.queryForObject(selQuery, rowMapper, prodId);
		return prods;
		
	}
	
	public List<Product> createProduct(String prodId, String prodCategory, String prodName){
		
		String insQuery = "INSERT INTO PRODUCTS(prodId,prodCategory,prodName) VALUES(?,?,?)";
		Object[] insArgs={prodId, prodCategory, prodName};		
		jdbcProdTemplate.update(insQuery, insArgs);
		
		return getAllProducts();
		
	}
	
	public List<Product> getAllProducts(){
		
		List<Product> prods = jdbcProdTemplate.query(
                "SELECT prodId, prodCategory, prodName  FROM Products",
                (rs, rowNum) -> new Product(rs.getString("prodId"),
                        rs.getString("prodCategory"), rs.getString("prodName"))
        );
		return prods;
		
	}

}
