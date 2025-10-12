package com.techiteasy.TechItEasy.mappers;

import com.techiteasy.TechItEasy.dtos.CIModuleDto;
import com.techiteasy.TechItEasy.dtos.CIModuleInputDto;
import com.techiteasy.TechItEasy.models.CIModule;

public class CIModuleMapper {

    public static CIModule toEntity(CIModuleInputDto ciModuleInputDto, CIModule existingCIModule) {
        if (existingCIModule == null) {
            existingCIModule = new CIModule();
        }

        existingCIModule.setName(ciModuleInputDto.name);
        existingCIModule.setType(ciModuleInputDto.type);
        existingCIModule.setPrice(ciModuleInputDto.price);

        return existingCIModule;
    }

    public static CIModuleDto toDto(CIModule ciModule) {
        CIModuleDto ciModuleDto = new CIModuleDto();

        ciModuleDto.id = ciModule.getId();
        ciModuleDto.name = ciModule.getName();
        ciModuleDto.type = ciModule.getType();
        ciModuleDto.price = ciModule.getPrice();

        return ciModuleDto;
    }

}
