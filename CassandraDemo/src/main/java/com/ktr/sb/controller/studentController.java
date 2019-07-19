package com.ktr.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ktr.sb.pojos.Student;
import com.ktr.sb.services.StudentService;

@RestController
public class studentController {
	
	@Autowired
	StudentService studServ;
	
	@GetMapping("/getstudents")
	List<Student> getAllStudent(){
		return studServ.getStudentsList();
	}
	
	@PostMapping("/savestudent")
	List<Student> saveStudent(@RequestBody Student stud){
		return studServ.saveStudent(stud);
	}

}
