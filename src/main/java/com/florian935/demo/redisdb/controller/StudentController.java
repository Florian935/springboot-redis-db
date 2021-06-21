package com.florian935.demo.redisdb.controller;

import com.florian935.demo.redisdb.domain.Student;
import com.florian935.demo.redisdb.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author florian935
 */
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1.0/students")
public class StudentController {

    StudentService studentService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAll() {

        final List<Student> students = studentService.getAll();

        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getById(@PathVariable final String id) {

        final Student student = studentService.getById(id);

        return ResponseEntity.ok(student);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> insert(@RequestBody @Valid final Student student) {

        final Student studentCreated = studentService.insert(student);

        return ResponseEntity.status(CREATED).body(studentCreated);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody @Valid final Student student) {

        final Student studentUpdated = studentService.update(student);

        return ResponseEntity.ok(studentUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final String id) {

        studentService.deleteById(id);

        return ResponseEntity.ok("Deleted successfully !");
    }
}
