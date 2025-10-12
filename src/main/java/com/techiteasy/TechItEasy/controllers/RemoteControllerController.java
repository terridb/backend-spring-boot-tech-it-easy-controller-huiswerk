package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.dtos.remotecontrollers.RemoteControllerDto;
import com.techiteasy.TechItEasy.dtos.remotecontrollers.RemoteControllerInputDto;
import com.techiteasy.TechItEasy.services.RemoteControllerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remote-controllers")
public class RemoteControllerController {

    private final RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerDto>> getAllRemoteControllers() {

        return ResponseEntity.ok(this.service.getAllRemoteControllers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteControllerById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRemoteControllerById(id));
    }

    @PostMapping
    public ResponseEntity<RemoteControllerDto> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerDto remoteControllerDto = this.service.createRemoteController(remoteControllerInputDto);

        return new ResponseEntity<>(remoteControllerDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> updateRemoteController(@PathVariable Long id, @Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerDto remoteControllerDto = this.service.updateRemoteController(id, remoteControllerInputDto);

        return ResponseEntity.ok(remoteControllerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemoteController(@PathVariable Long id) {
        this.service.deleteRemoteController(id);

        return ResponseEntity.noContent().build();
    }
}
