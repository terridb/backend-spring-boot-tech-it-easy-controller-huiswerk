package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.dtos.wallbrackets.WallBracketDto;
import com.techiteasy.TechItEasy.dtos.wallbrackets.WallBracketInputDto;
import com.techiteasy.TechItEasy.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wall-brackets")
public class WallBracketController {

    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {

        return ResponseEntity.ok(this.service.getAllWallBrackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketDto> getWallBracketById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getWallBracketById(id));
    }

    @PostMapping
    public ResponseEntity<WallBracketDto> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto wallBracketDto = this.service.createWallBracket(wallBracketInputDto);

        return new ResponseEntity<>(wallBracketDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto wallBracketDto = this.service.updateWallBracket(id, wallBracketInputDto);

        return ResponseEntity.ok(wallBracketDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallBracket(@PathVariable Long id) {
        this.service.deleteWallBracket(id);

        return ResponseEntity.noContent().build();
    }
}
