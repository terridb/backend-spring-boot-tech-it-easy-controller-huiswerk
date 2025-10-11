package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.services.RemoteControllerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remote-controllers")
public class RemoteControllerController {

    private final RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService service) {
        this.service = service;
    }

}
