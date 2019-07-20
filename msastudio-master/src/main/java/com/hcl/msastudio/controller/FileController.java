package com.hcl.msastudio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.msastudio.model.FileUpload;
import com.hcl.msastudio.service.FileSourceService;
import com.hcl.msastudio.service.SecurityService;
import com.hcl.msastudio.service.StorageService;
import com.hcl.msastudio.validator.FileUploadValidator;



@Controller
public class FileController {

	
	private final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	FileSourceService sourceService;
	
	@Autowired
    private FileUploadValidator fileUploadValidator;

	List<String> files = new ArrayList<String>();

	@GetMapping("/testt")
	public String listUploadedFiles(Model model) {
		return "uploadForm";
	}
	
	@GetMapping("/analyseMicroService")
	public String analyseMicroService(Model model) {
		logger.info("Fetching Technology Infos");
		model.addAttribute("technologies",storageService.getTechnologies());
		return "analyseMicroService";
	}

	@PostMapping("/analyseresult")
	public String handleFileUpload(@ModelAttribute("uploadForm") @Valid FileUpload input, BindingResult result, Model model) {
		fileUploadValidator.validate(input, result);
		
		if(result.hasErrors()) {
			logger.info("Fetching Technology Infos");
			model.addAttribute("selectedId", input.getProjectType());
			model.addAttribute("technologies",storageService.getTechnologies());
			return "analyseMicroService";
		}else {
			logger.info("Calling File upload");
			try {
				String userId = securityService.findLoggedInUsername();
				storageService.store(userId,input.getProjectType(),input.getFile());
				model.addAttribute("message", "You successfully uploaded " + input.getFile().getOriginalFilename() + "!");
				files.add(input.getFile().getOriginalFilename());
			} catch (Exception e) {
				model.addAttribute("message", "FAIL to upload " + input.getFile().getOriginalFilename() + "!");
			}
			return "analyseresult";
		}
		
		
	}
	
	@GetMapping(value = "/getSource/{projectId}/{className}")
	public ResponseEntity<byte[]> getClassSource(@PathVariable("projectId") String projectId,@PathVariable("className") String className){

	    String reqData = sourceService.getClassSource(projectId, className);
	    byte[] output = {};
	    String filename="failure";
	    if(!StringUtils.isEmpty(reqData)) {
	    	output = reqData.getBytes();
	    	filename= className;
	    }

	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("charset", "utf-8");
	    responseHeaders.setContentType(MediaType.valueOf("text/html"));
	    responseHeaders.setContentLength(output.length);
	    responseHeaders.set("Content-disposition", "attachment; filename="+filename+".java" );

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSource/{projectId}/{className}/{methodName}")
	public ResponseEntity<byte[]> getMethodSource(@PathVariable("projectId") String projectId,@PathVariable("className") String className,@PathVariable("methodName") String methodName){

	    String reqData = sourceService.getMethodSource(projectId, className, methodName);
	    byte[] output = {};
	    String filename="failure";
	    if(!StringUtils.isEmpty(reqData)) {
	    	output = reqData.getBytes();
	    	filename= className+"_"+methodName;
	    }

	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("charset", "utf-8");
	    responseHeaders.setContentType(MediaType.valueOf("text/html"));
	    responseHeaders.setContentLength(output.length);
	    responseHeaders.set("Content-disposition", "attachment; filename="+filename+".java" );

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}

	/*@GetMapping("/gellallfiles")
	public String getListFiles(Model model) {
		model.addAttribute("files",
				files.stream()
						.map(fileName -> MvcUriComponentsBuilder
								.fromMethodName(UploadController.class, "getFile", fileName).build().toString())
						.collect(Collectors.toList()));
		model.addAttribute("totalFiles", "TotalFiles: " + files.size());
		return "listFiles";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}*/
}