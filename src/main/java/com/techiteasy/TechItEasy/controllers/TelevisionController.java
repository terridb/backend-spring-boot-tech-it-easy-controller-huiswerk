package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.dtos.*;
import com.techiteasy.TechItEasy.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @PutMapping("/{id}/remotecontroller")
    public ResponseEntity<TelevisionDto> assignRemoteControllerToTelevision(@PathVariable Long id, @RequestBody IdInputDto input) {

        TelevisionDto televisionDto = service.assignRemoteControllerToTelevision(id, input.id);
        return ResponseEntity.ok(televisionDto);
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {

        return ResponseEntity.ok(this.service.getAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable Long id) {

        return ResponseEntity.ok(service.getTelevisionById(id));
    }

    @GetMapping("/sales")
    public ResponseEntity<List<TelevisionSalesDto>> getSalesAllTelevisions() {

        return ResponseEntity.ok(this.service.getSalesAllTelevisions());
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto televisionDto = this.service.createTelevision(televisionInputDto);

        return new ResponseEntity<>(televisionDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto televisionDto = this.service.updateTelevision(id, televisionInputDto);

        return ResponseEntity.ok(televisionDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        this.service.deleteTelevision(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TelevisionDto> patchTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionPatchDto televisionPatchDto) {
        TelevisionDto televisionDto = this.service.patchTelevision(id, televisionPatchDto);

        return ResponseEntity.ok(televisionDto);
    }
}