package com.example.Lab3.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @Min(0)
    @Max(10)
    @NotNull
    private Double marks;

    @NotNull
    private Boolean gender;

    @NotBlank
    private String faculty;

    @NotEmpty
    private List<String> hobbies;
}
