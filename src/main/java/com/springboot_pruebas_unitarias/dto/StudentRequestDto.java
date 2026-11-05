package com.springboot_pruebas_unitarias.dto;

import com.springboot_pruebas_unitarias.model.StudentModel;

public record StudentRequestDto(
        Integer id,
        String name,
        String lastName,
        String phone,
        String eMail) {

    public StudentModel toModel() {
        return new StudentModel(
                this.id,
                this.name,
                this.lastName,
                this.phone,
                this.eMail);
    }

}
