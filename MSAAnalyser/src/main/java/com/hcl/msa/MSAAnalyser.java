package com.hcl.msa;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJms
@ComponentScan
public class MSAAnalyser {
	
	
	public static void main(String[] args) 
	{
		
		SpringApplication.run(MSAAnalyser.class, args);   
	}
	   
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("msa.reqeust.queue");
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
