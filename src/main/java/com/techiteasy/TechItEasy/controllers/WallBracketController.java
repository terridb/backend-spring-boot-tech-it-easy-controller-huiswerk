package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.services.WallBracketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wall-brackets")
public class WallBracketController {

    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {
        this.service = service;
    }
}
