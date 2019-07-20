package com.hcl.msa.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hcl.msa.entity.ClassInfo;

public class RestClientUtil {
    public void getClassInfoByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/user/classinfo/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<ClassInfo> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ClassInfo.class, 1);
        ClassInfo classInfo = responseEntity.getBody();
        System.out.println("Id:"+classInfo.getId()+", Class Name:"+classInfo.getClassName()
                 +", Package Name:"+classInfo.getPackageName());      
    }
	public void getAllClassInfosDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/user/classinfos";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<ClassInfo[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ClassInfo[].class);
        ClassInfo[] classInfos = responseEntity.getBody();
        for(ClassInfo classInfo : classInfos) {
              System.out.println("Id:"+classInfo.getId()+", Class Name:"+classInfo.getClassName()
                      +", Package: "+classInfo.getPackageName());
        }
    }
    public void addClassInfoDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/user/classinfo";
	    ClassInfo objClassInfo = new ClassInfo();
	    objClassInfo.setClassName("Spring REST Security using Hibernate");
	    objClassInfo.setPackageName("Spring");
        HttpEntity<ClassInfo> requestEntity = new HttpEntity<ClassInfo>(objClassInfo, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateClassInfoDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/user/classinfo";
	    ClassInfo objClassInfo = new ClassInfo();
	    objClassInfo.setId(1);
	    objClassInfo.setClassName("Update:Java Concurrency");
	    objClassInfo.setPackageName("Java");
        HttpEntity<ClassInfo> requestEntity = new HttpEntity<ClassInfo>(objClassInfo, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteClassInfoDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9090/user/classinfo/{id}";
        HttpEntity<ClassInfo> requestEntity = new HttpEntity<ClassInfo>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
   /* public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getClassInfoByIdDemo();
    	util.getAllClassInfosDemo();
    	//util.addClassInfoDemo();
    	//util.updateClassInfoDemo();
    	//util.deleteClassInfoDemo();
    } */   
}
