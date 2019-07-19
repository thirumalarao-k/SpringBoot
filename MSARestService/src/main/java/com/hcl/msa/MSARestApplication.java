package com.hcl.msa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MSARestApplication {  
	public static void main(String[] args) {
		SpringApplication.run(MSARestApplication.class, args);
    }  
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).pathMapping("")
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.hcl.msa"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(apiInfo());
	    }

	    private ApiInfo apiInfo() {
	        ApiInfo apiInfo = new ApiInfo(
	                "Rest  API",
	                "Rest MicroService API",
	                "Rest 1.0",
	                "http://localhost:9090/msa",
	                "Test",
	                "Demo-Employee Model",
	                "http://localhost:9090/msa");
	        return apiInfo;
	    }
}            