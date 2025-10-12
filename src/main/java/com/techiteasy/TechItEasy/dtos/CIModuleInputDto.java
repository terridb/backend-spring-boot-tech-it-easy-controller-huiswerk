package com.techiteasy.TechItEasy.dtos;

import jakarta.validation.constraints.*;

public class CIModuleInputDto {

    @NotBlank
    @Size(min=3, max=128)
    public String name;

    @NotBlank
    @Size(min=3, max=128)
    public String type;

    @NotNull
    @Positive
    @Digits(integer = 10, fraction = 2)
    public Double price;
}
