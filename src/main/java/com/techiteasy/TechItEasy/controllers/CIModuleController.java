package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.services.CIModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ci-modules")
public class CIModuleController {

    private final CIModuleService service;

    public CIModuleController(CIModuleService service) {
        this.service = service;
    }
}
