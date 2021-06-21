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
import static org.springframework.http.HttpStatus.OK;
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
    @ResponseBody
    @ResponseStatus(OK)
    public List<Student> getAll() {

        return studentService.getAll();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public Student getById(@PathVariable final String id) {

        return studentService.getById(id);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(CREATED)
    public Student insert(@RequestBody @Valid final Student student) {

        return studentService.insert(student);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(OK)
    public Student update(@RequestBody @Valid final Student student) {

        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(OK)
    public String delete(@PathVariable final String id) {

        studentService.deleteById(id);

        return "Deleted successfully !";
    }
}
