package com.ktr.sb.db.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MySqlDBConfig {
	
	@Bean(name = "dbProductService")
    @ConfigurationProperties(prefix = "spring.dbproductservice.datasource")
	@Primary
    public DataSource createProductServiceDataSource() {
	      return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "jdbcProductService")
	@Autowired
	public JdbcTemplate createJdbcTemplate_ProductService(@Qualifier("dbProductService") DataSource productServiceDS) {
	      return new JdbcTemplate(productServiceDS);
	}

}
