package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.dtos.CIModuleDto;
import com.techiteasy.TechItEasy.dtos.CIModuleInputDto;
import com.techiteasy.TechItEasy.exceptions.RecordNotFoundException;
import com.techiteasy.TechItEasy.mappers.CIModuleMapper;
import com.techiteasy.TechItEasy.models.CIModule;
import com.techiteasy.TechItEasy.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CIModuleService {

    private final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CIModuleDto> getAllCIModules() {
        List<CIModule> ciModules = ciModuleRepository.findAll();
        List<CIModuleDto> dtoCiModules = new ArrayList<>();

        for (CIModule ciModule : ciModules) {
            dtoCiModules.add(CIModuleMapper.toDto(ciModule));
        }

        return dtoCiModules;
    }

    public CIModuleDto getCIModuleById(Long id) {
        return CIModuleMapper.toDto(
                ciModuleRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException("CI-Module with id " + id + " not found")));
    }

    public CIModuleDto createCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule ciModule = CIModuleMapper.toEntity(ciModuleInputDto, null);

        CIModule savedCIModule = ciModuleRepository.save(ciModule);

        return CIModuleMapper.toDto(savedCIModule);
    }

    public CIModuleDto updateCIModule(Long id, CIModuleInputDto ciModuleInputDto) {
        CIModule existingCIModule = ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CI-module with id " + id + " not found"));

        CIModule updatedCIModule = CIModuleMapper.toEntity(ciModuleInputDto, existingCIModule);
        CIModule savedCIModule = ciModuleRepository.save(updatedCIModule);
        return CIModuleMapper.toDto(savedCIModule);
    }

    public void deleteCIModule(Long id) {
        ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CI-module with id " + id + " not found"));

        ciModuleRepository.deleteById(id);
    }
}
