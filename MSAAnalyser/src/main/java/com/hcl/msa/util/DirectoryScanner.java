package com.hcl.msa.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class DirectoryScanner {
	
	//loop through a directory to get java, properties, xml config file list
	public List<Path> findAllMatchingFilesInDir(String rootDir, String extn) throws IOException{
		List<Path> fileList = new ArrayList<Path>();
		Path rootPath = Paths.get(rootDir);

		 try {
		   Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
		     String[] exclusionFolders = {".settings","build","target","src\\test"};
		     @Override
		     public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		       String fileString = file.toAbsolutePath().toString();
		       ;
		       if(!Arrays.stream(exclusionFolders).parallel().anyMatch(fileString::contains) && fileString.endsWith(extn)){
		         fileList.add(file.toAbsolutePath());
		         
		       }
		       return FileVisitResult.CONTINUE;
		     }
		   });
		 } catch(IOException e){
		     e.printStackTrace();
		 }
		 return fileList;

	}
	
	//read file content into a string
	public String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader=null;
		try {
			reader= new BufferedReader(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		if (reader!=null) {
			char[] buf = new char[10];
			int numRead = 0;
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			reader.close();
		}
		return  fileData.toString();	
	}
}
