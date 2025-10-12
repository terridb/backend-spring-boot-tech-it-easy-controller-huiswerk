package com.techiteasy.TechItEasy.mappers;

import com.techiteasy.TechItEasy.dtos.remotecontrollers.RemoteControllerInputDto;
import com.techiteasy.TechItEasy.dtos.remotecontrollers.RemoteControllerDto;
import com.techiteasy.TechItEasy.models.RemoteController;

public class RemoteControllerMapper {

    public static RemoteController toEntity(RemoteControllerInputDto remoteControllerInputDto, RemoteController existingRemoteController) {
        if (existingRemoteController == null) {
            existingRemoteController = new RemoteController();
        }

        existingRemoteController.setCompatibleWith(remoteControllerInputDto.compatibleWith);
        existingRemoteController.setBatteryType(remoteControllerInputDto.batteryType);
        existingRemoteController.setName(remoteControllerInputDto.name);
        existingRemoteController.setBrand(remoteControllerInputDto.brand);
        existingRemoteController.setPrice(remoteControllerInputDto.price);
        existingRemoteController.setOriginalStock(remoteControllerInputDto.originalStock);

        return existingRemoteController;
    }

    public static RemoteControllerDto toDto(RemoteController remoteController) {
        RemoteControllerDto remoteControllerDto = new RemoteControllerDto();

        remoteControllerDto.id = remoteController.getId();
        remoteControllerDto.compatibleWith = remoteController.getCompatibleWith();
        remoteControllerDto.batteryType = remoteController.getBatteryType();
        remoteControllerDto.name = remoteController.getName();
        remoteControllerDto.brand = remoteController.getBrand();
        remoteControllerDto.price = remoteController.getPrice();

        return remoteControllerDto;
    }

}
