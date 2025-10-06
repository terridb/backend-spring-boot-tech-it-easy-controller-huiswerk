package com.techiteasy.TechItEasy.mappers;

import com.techiteasy.TechItEasy.dtos.TelevisionDto;
import com.techiteasy.TechItEasy.dtos.TelevisionInputDto;
import com.techiteasy.TechItEasy.models.Television;

public class TelevisionMapper {

    public static Television toEntity(TelevisionInputDto televisionInputDto, Television existingTelevision) {
        if (existingTelevision == null) {
            existingTelevision = new Television();
        }

        existingTelevision.setType(televisionInputDto.type);
        existingTelevision.setBrand(televisionInputDto.brand);
        existingTelevision.setName(televisionInputDto.name);
        existingTelevision.setPrice(televisionInputDto.price);
        existingTelevision.setAvailableSize(televisionInputDto.availableSize);
        existingTelevision.setRefreshRate(televisionInputDto.refreshRate);
        existingTelevision.setScreenType(televisionInputDto.screenType);
        existingTelevision.setScreenQuality(televisionInputDto.screenQuality);
        existingTelevision.setSmartTv(televisionInputDto.smartTv);
        existingTelevision.setWifi(televisionInputDto.wifi);
        existingTelevision.setVoiceControl(televisionInputDto.voiceControl);
        existingTelevision.setHdr(televisionInputDto.hdr);
        existingTelevision.setBluetooth(televisionInputDto.bluetooth);
        existingTelevision.setAmbiLight(televisionInputDto.ambiLight);
        existingTelevision.setOriginalStock(televisionInputDto.originalStock);

        return existingTelevision;
    }

    public static TelevisionDto toDto(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();

        televisionDto.id = television.getId();
        televisionDto.type = television.getType();
        televisionDto.brand = television.getBrand();
        televisionDto.name = television.getName();
        televisionDto.price = television.getPrice();
        televisionDto.availableSize = television.getAvailableSize();
        televisionDto.refreshRate = television.getRefreshRate();
        televisionDto.screenType = television.getScreenType();
        televisionDto.screenQuality = television.getScreenQuality();
        televisionDto.smartTv = television.getSmartTv();
        televisionDto.wifi = television.getWifi();
        televisionDto.voiceControl = television.getVoiceControl();
        televisionDto.hdr = television.getHdr();
        televisionDto.bluetooth = television.getBluetooth();
        televisionDto.ambiLight = television.getAmbiLight();
        televisionDto.originalStock = television.getOriginalStock();
        televisionDto.sold = television.getSold();

        return televisionDto;
    }
}
