package com.florian935.demo.redisdb.service;

import com.florian935.demo.redisdb.domain.Student;

import java.util.List;

/**
 * @author florian935
 */
public interface StudentService {
    List<Student> getAll();

    Student getById(final String id);

    Student insert(final Student student);

    Student update(final Student student);

    void deleteById(final String id);

    Student getErrorStudent(final String errMsg);
}
