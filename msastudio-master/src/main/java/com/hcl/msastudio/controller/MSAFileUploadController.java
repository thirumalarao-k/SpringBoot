/*package com.hcl.msastudio.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hcl.msastudio.constants.MSAStudioConstants;
import com.hcl.msastudio.util.MSAMessageProducer;
import com.hcl.msastudio.util.UnZip;
import com.hcl.msastudio.util.UnzipUtility;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/api")
public class MSAFileUploadController {

	private final Logger logger = LoggerFactory.getLogger(MSAFileUploadController.class);

	//Single file upload
	@PostMapping("/analyseresult")
	public String uploadFile(
			@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		logger.debug("Single file upload!");

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:analyseresult";

		}

		try {

			saveUploadedFiles(Arrays.asList(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		UnzipUtility unzipper = new UnzipUtility();

		try {
			unzipper.unzip(MSAStudioConstants.UPLOADED_DIR+file.getOriginalFilename(),MSAStudioConstants.UN_ZIP_DIR);
		} catch (Exception ex) {
			// some errors occurred
			ex.printStackTrace();
		}
		System.out.println("Uploading to message Producer");
		MSAMessageProducer.uploadMessage(MSAStudioConstants.UN_ZIP_DIR+	file.getOriginalFilename());
		System.out.println("Uploading is Done");

		return "redirect:analyseresult"; 


	}

	// Multiple file upload
	@PostMapping("/analyseresult/multi")
	public ResponseEntity<?> uploadFileMulti(
			@RequestParam("extraField") String extraField,
			@RequestParam("files") MultipartFile[] uploadfiles) {

		logger.debug("Multiple file upload!");

		String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
				.filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

		if (StringUtils.isEmpty(uploadedFileName)) {
			return new ResponseEntity<Object>("please select a file!", HttpStatus.OK);
		}

		try {

			saveUploadedFiles(Arrays.asList(uploadfiles));

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>("Successfully uploaded - "
				+ uploadedFileName, HttpStatus.OK);

	}

	//save file
	private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue; 
			}

			byte[] bytes = file.getBytes();
			Path path = Paths.get(MSAStudioConstants.UPLOADED_DIR + file.getOriginalFilename());
			Files.write(path, bytes);

		}

	}
	@GetMapping("/uploadStatus")
	public String uploadStatus(Map<String, Object> model) {
		return "analyseresult";
	}
}
*/