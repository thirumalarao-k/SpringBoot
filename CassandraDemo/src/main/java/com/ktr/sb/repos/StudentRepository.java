package com.ktr.sb.repos;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.ktr.sb.pojos.Student;

@Repository
public interface StudentRepository extends CassandraRepository<Student, String>{
}