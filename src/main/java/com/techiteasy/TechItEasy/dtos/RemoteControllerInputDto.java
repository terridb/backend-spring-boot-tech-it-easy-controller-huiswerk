package com.techiteasy.TechItEasy.dtos;

import jakarta.validation.constraints.*;

public class RemoteControllerInputDto {

    @NotBlank
    public String compatibleWith;

    @NotBlank
    @Size(min=1, max=40)
    public String batteryType;

    @NotBlank
    @Size(min=2, max=128)
    public String name;

    @NotBlank
    @Size(min=2, max=128)
    public String brand;

    @NotNull
    @Positive
    @Digits(integer = 10, fraction = 2)
    public Double price;

    @NotNull
    @PositiveOrZero
    public Integer originalStock;
}
