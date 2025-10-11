package com.techiteasy.TechItEasy.dtos;

import com.techiteasy.TechItEasy.models.AvailableSize;
import com.techiteasy.TechItEasy.models.RefreshRate;
import com.techiteasy.TechItEasy.models.ScreenQuality;
import com.techiteasy.TechItEasy.models.ScreenType;
import jakarta.validation.constraints.*;

public class TelevisionInputDto {

    @NotBlank
    @Size(min=3, max=128)
    public String type;

    @NotBlank
    @Size(min=2, max=128)
    public String brand;

    @NotBlank
    @Size(min=3, max=128)
    public String name;

    @NotNull
    @Positive
    @Digits(integer = 10, fraction = 2)
    public Double price;

    @NotNull
    public AvailableSize availableSize;

    @NotNull
    public RefreshRate refreshRate;

    @NotNull
    public ScreenType screenType;

    @NotNull
    public ScreenQuality screenQuality;

    @NotNull
    public Boolean smartTv;

    @NotNull
    public Boolean wifi;

    @NotNull
    public Boolean voiceControl;

    @NotNull
    public Boolean hdr;

    @NotNull
    public Boolean bluetooth;

    @NotNull
    public Boolean ambiLight;

    @NotNull
    @PositiveOrZero
    public Integer originalStock;
}
