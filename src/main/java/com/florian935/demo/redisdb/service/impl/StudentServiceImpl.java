package com.florian935.demo.redisdb.service.impl;

import com.florian935.demo.redisdb.domain.Student;
import com.florian935.demo.redisdb.repository.StudentRepository;
import com.florian935.demo.redisdb.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author florian935
 */
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {

        return studentRepository.findAll();
    }

    @Override
    public Student getById(final String id) {

        return studentRepository.findById(id)
                .orElse(
                        getErrorStudent(String.format("No student found with ID %s", id))
                );
    }

    @Override
    public Student insert(final Student student) {

        return save(student);
    }

    @Override
    public Student update(final Student student) {

        return save(student);
    }

    @Override
    public void deleteById(final String id) {

        studentRepository.deleteById(id);
    }

    private Student save(final Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student getErrorStudent(final String errMsg) {

        return Student.builder().errMsg(errMsg).build();
    }
}
