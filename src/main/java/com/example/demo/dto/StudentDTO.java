package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Singular;

@Data
public class StudentDTO {
    @NotNull
    @Size(min = 2)
    private String name;
}
