package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.models.Television;
import com.techiteasy.TechItEasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionRepository repos;

    public TelevisionController(TelevisionRepository repos) {
        this.repos = repos;
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {

        return ResponseEntity.ok(this.repos.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable Long id) {
        Optional<Television> ot = this.repos.findById(id);

        return ot.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        Television savedTelevision = this.repos.save(television);

        return ResponseEntity.created(null).body(savedTelevision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        Optional<Television> ot = this.repos.findById(id);
        if (ot.isPresent()) {
            Television existingTelevision = ot.get();

            existingTelevision.setType(television.getType());
            existingTelevision.setBrand(television.getBrand());
            existingTelevision.setName(television.getName());
            existingTelevision.setPrice(television.getPrice());
            existingTelevision.setAvailableSize(television.getAvailableSize());
            existingTelevision.setRefreshRate(television.getRefreshRate());
            existingTelevision.setScreenType(television.getScreenType());
            existingTelevision.setScreenQuality(television.getScreenQuality());
            existingTelevision.setSmartTv(television.getSmartTv());
            existingTelevision.setWifi(television.getWifi());
            existingTelevision.setVoiceControl(television.getVoiceControl());
            existingTelevision.setHdr(television.getHdr());
            existingTelevision.setBluetooth(television.getBluetooth());
            existingTelevision.setAmbiLight(television.getAmbiLight());
            existingTelevision.setOriginalStock(television.getOriginalStock());
            existingTelevision.setSold(television.getSold());

            this.repos.save(existingTelevision);
            return ResponseEntity.ok(existingTelevision);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) {
        Optional<Television> ot = this.repos.findById(id);

        if (ot.isPresent()) {
            this.repos.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}