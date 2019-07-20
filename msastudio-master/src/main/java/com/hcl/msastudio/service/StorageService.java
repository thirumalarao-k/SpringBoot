package com.hcl.msastudio.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.msastudio.domain.ClassInfo;
import com.hcl.msastudio.domain.ProjectSetting;
import com.hcl.msastudio.domain.TechnologyInfo;
import com.hcl.msastudio.util.MSAMessageProducer;
import com.hcl.msastudio.util.UnzipUtility;


@Service
public class StorageService {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;
	
	private final Path rootLocation = Paths.get("upload-dir");
	private static final String PATH_PROJECTSETTING = "projectSetting";

	public void store(String userId, String technologyId, MultipartFile file){
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

			UnzipUtility unzipper = new UnzipUtility();

			try {
				unzipper.unzip(Paths.get("upload-dir").toAbsolutePath()+"\\"+file.getOriginalFilename(),Paths.get("upload-dir").toAbsolutePath().toString());
			} catch (Exception ex) {
				// some errors occurred
				ex.printStackTrace();
			}
			System.out.println("Uploading to message Producer");
	
			String fileName = file.getOriginalFilename().split("\\.")[0];
			
			boolean isUpdated = updateProjectSetting(userId, technologyId, fileName);
			if(isUpdated) {
				MSAMessageProducer.uploadMessage(Paths.get("upload-dir").toAbsolutePath()+"\\"+fileName);
				System.out.println("Uploading is Done");
			}else {
				System.out.println("Update Project Setting is Failed");
				throw new RuntimeException("Update Project Setting FAIL!");
			}
		} catch (Exception e) {
			System.out.println("Uploading is Failed");
			throw new RuntimeException("FAIL!");
		}
	}
	
	public Object getTechnologies() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		String uri = msaRestServiceUrl +"/technologies";
		ResponseEntity < List < TechnologyInfo >> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<TechnologyInfo>> () {});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<TechnologyInfo> dtoList=response.getBody();

		return dtoList;
	}
	
	public boolean updateProjectSetting(String userId, String technologyId, String projectName) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString=null;
		try {
			ProjectSetting projSet = new ProjectSetting();
			projSet.setCreatedBy(userId);
			projSet.setProjName(projectName);
			projSet.setTechnologyId(technologyId);
			
			jsonInString = mapper.writeValueAsString(projSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" >>>>> BEFORE PERSISTING PROJECT SETTING INFO "+jsonInString);
		String projName=null;
		if (jsonInString != null) {
			projName = (String) msaRestServiceCall(jsonInString, "INSERT", PATH_PROJECTSETTING);
		}
		System.out.println(">>>>> PERSISTED PROJECT INFO >>>>> "+projName);
		return projName!=null;
	}
	
	private Object msaRestServiceCall(String jsonInString, String operationType, String path) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		String uri = msaRestServiceUrl+"/"+path;
		HttpEntity<String> requestEntity = new HttpEntity<>(jsonInString, headers);
		ResponseEntity<String> result=null;
		String resultStr="";
		try {
			result=restTemplate.postForEntity(uri, requestEntity,String.class);
			resultStr=result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultStr;
	}

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }

}