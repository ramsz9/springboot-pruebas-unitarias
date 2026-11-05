package com.springboot_pruebas_unitarias.dto;

public record StudentResponseDto(
        Integer id,
        String name,
        String lastName,
        String phone,
        String eMail) {

}
