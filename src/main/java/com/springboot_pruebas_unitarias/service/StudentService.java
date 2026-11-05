package com.springboot_pruebas_unitarias.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot_pruebas_unitarias.dto.StudentRequestDto;
import com.springboot_pruebas_unitarias.dto.StudentResponseDto;
import com.springboot_pruebas_unitarias.model.StudentModel;
import com.springboot_pruebas_unitarias.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDto> findAll() {
        return studentRepository.findAll().stream().map(StudentModel::toDto).toList();
    }

    public StudentResponseDto create(StudentRequestDto dto) {
        return studentRepository.save(dto.toModel()).toDto();
    }

}
