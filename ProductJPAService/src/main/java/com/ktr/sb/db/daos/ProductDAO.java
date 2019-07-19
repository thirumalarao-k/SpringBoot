package com.ktr.sb.db.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ktr.sb.pojos.Product;

public interface ProductDAO extends JpaRepository<Product,String>{
}
