package com.ktr.sb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktr.sb.pojos.Student;
import com.ktr.sb.repos.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studRepo;
	
	public List<Student> getStudentsList(){		
		return studRepo.findAll();
	}
	
	public List<Student> saveStudent(Student stud){
		studRepo.save(stud);
		return getStudentsList();
		
	}

}
