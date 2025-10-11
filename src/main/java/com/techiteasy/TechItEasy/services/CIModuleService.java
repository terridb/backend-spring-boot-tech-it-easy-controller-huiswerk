package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CIModuleService {

    private final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }
}
