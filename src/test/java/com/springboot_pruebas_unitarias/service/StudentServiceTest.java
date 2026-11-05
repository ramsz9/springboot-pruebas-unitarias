package com.springboot_pruebas_unitarias.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot_pruebas_unitarias.dto.StudentRequestDto;
import com.springboot_pruebas_unitarias.dto.StudentResponseDto;
import com.springboot_pruebas_unitarias.model.StudentModel;
import com.springboot_pruebas_unitarias.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Should return student list")
    void shouldReturnStudentList() {
        List<StudentModel> studentModelList = List.of(
                new StudentModel(1, "Floor", "Jansen", "+52 123 11 22 33", "f.jansen@gmail.com"),
                new StudentModel(2, "John", "Doe", "+52 123 44 55 66", "j.doe@gmail.com"));
        when(studentRepository.findAll()).thenReturn(studentModelList);

        List<StudentResponseDto> responseDtos = studentService.findAll();

        assertThat(responseDtos).hasSize(2);
        assertThat(responseDtos.get(0).name()).isEqualTo("Floor");
        assertThat(responseDtos.get(1).eMail()).isEqualTo("j.doe@gmail.com");
        verify(studentRepository).findAll();
    }

    @Test
    @DisplayName("Should create a student")
    void shouldCreateStudent() {
        StudentRequestDto studentRequestDto = new StudentRequestDto(null, "John", "Doe", "+52 123 11 22 33",
                "j.doe@email.com");
        StudentModel savedStudent = new StudentModel(1, "John", "Doe", "+52 123 11 22 33", "j.doe@email.com");
        when(studentRepository.save(any(StudentModel.class))).thenReturn(savedStudent);

        StudentResponseDto responseDto = studentService.create(studentRequestDto);

        assertThat(responseDto.id()).isEqualTo(1);
        assertThat(responseDto.name()).isEqualTo("John");
        assertThat(responseDto.lastName()).isEqualTo("Doe");
        assertThat(responseDto.phone()).isEqualTo("+52 123 11 22 33");
        assertThat(responseDto.eMail()).isEqualTo("j.doe@email.com");
        verify(studentRepository).save(any(StudentModel.class));
    }
}
