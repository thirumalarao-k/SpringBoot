package com.hcl.msastudio;

import javax.annotation.Resource;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hcl.msastudio.service.StorageService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class MSAStudioApplication extends SpringBootServletInitializer implements CommandLineRunner{
	@Resource
	StorageService storageService;
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MSAStudioApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(MSAStudioApplication.class, args);
	}
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("msa.reqeust.queue");
	}
	@Bean
	public ModelMapper modelMapper() {		
	    return new ModelMapper();
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	public ObjectMapper mapper(){
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule moduleDeserializer = new SimpleModule();
		//moduleDeserializer.addDeserializer(Date.class, new CustomJsonDateDeserializer());		
		mapper.registerModule(moduleDeserializer);
		
		SimpleModule moduleSerializer = new SimpleModule();
		//moduleSerializer.addSerializer(Date.class, new CustomJsonDateSerializer());		
		mapper.registerModule(moduleSerializer);
		
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);		
		
		return mapper;
	}
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).pathMapping("http://localhost:8080/insurance")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.insurance"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Insurance Api",
                "Rest Insurance API",
                "Insurance 1.0",
                "http://localhost:8080/insurance",
                "Insurance",
                "Insurance-10765",
                "http://localhost:8080/insurance");
        return apiInfo;
    }
      
 @Override
	public void run(String... args) throws Exception {
		try {
			storageService.deleteAll();
			storageService.init();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
