package com.techiteasy.TechItEasy.dtos;

import com.techiteasy.TechItEasy.models.AvailableSize;
import com.techiteasy.TechItEasy.models.RefreshRate;
import com.techiteasy.TechItEasy.models.ScreenQuality;
import com.techiteasy.TechItEasy.models.ScreenType;
import jakarta.validation.constraints.*;

public class TelevisionPatchDto {

    @Size(min=3, max=128)
    public String type;

    @Size(min=2, max=128)
    public String brand;

    @Size(min=3, max=128)
    public String name;

    @Positive
    @Digits(integer = 5, fraction = 2)
    public Double price;

    public AvailableSize availableSize;

    public RefreshRate refreshRate;

    public ScreenType screenType;

    public ScreenQuality screenQuality;

    public Boolean smartTv;

    public Boolean wifi;

    public Boolean voiceControl;

    public Boolean hdr;

    public Boolean bluetooth;

    public Boolean ambiLight;

    @PositiveOrZero
    public Integer originalStock;
}
