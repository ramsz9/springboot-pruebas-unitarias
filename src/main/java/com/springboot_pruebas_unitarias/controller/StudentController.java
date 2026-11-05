package com.springboot_pruebas_unitarias.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot_pruebas_unitarias.dto.StudentRequestDto;
import com.springboot_pruebas_unitarias.dto.StudentResponseDto;
import com.springboot_pruebas_unitarias.service.StudentService;

@Controller
@RequestMapping("${api.student.url}")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentRequestDto studentDto) {
        StudentResponseDto rsDto = studentService.create(studentDto);
        return new ResponseEntity<>(rsDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

}
