package com.florian935.demo.redisdb.repository;

import com.florian935.demo.redisdb.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author florian935
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
