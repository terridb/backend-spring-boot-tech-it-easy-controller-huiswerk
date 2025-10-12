package com.techiteasy.TechItEasy.dtos.televisions;

import com.techiteasy.TechItEasy.dtos.cimodules.CIModuleDto;
import com.techiteasy.TechItEasy.dtos.remotecontrollers.RemoteControllerDto;
import com.techiteasy.TechItEasy.models.AvailableSize;
import com.techiteasy.TechItEasy.models.RefreshRate;
import com.techiteasy.TechItEasy.models.ScreenQuality;
import com.techiteasy.TechItEasy.models.ScreenType;

public class TelevisionDto {
    public Long id;
    public String type;
    public String brand;
    public String name;
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
    public RemoteControllerDto remoteController;
    public CIModuleDto ciModule;
}
