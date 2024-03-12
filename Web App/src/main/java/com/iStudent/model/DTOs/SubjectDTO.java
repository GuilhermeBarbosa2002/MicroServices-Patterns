package com.iStudent.model.DTOs;

import javax.validation.constraints.NotBlank;

public class SubjectDTO {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
