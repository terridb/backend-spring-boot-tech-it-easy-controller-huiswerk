package com.techiteasy.TechItEasy.dtos;

import jakarta.validation.constraints.*;

public class WallBracketInputDto {

    @NotBlank
    @Size(min=3, max=128)
    public String size;

    @NotNull
    public Boolean adjustable;

    @NotBlank
    @Size(min=3, max=128)
    public String name;

    @NotNull
    @Positive
    @Digits(integer = 10, fraction = 2)
    public Double price;
}
