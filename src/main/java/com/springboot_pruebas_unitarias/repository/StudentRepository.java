package com.springboot_pruebas_unitarias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot_pruebas_unitarias.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
}
