package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.dtos.TelevisionDto;
import com.techiteasy.TechItEasy.dtos.TelevisionInputDto;
import com.techiteasy.TechItEasy.exceptions.RecordNotFoundException;
import com.techiteasy.TechItEasy.models.Television;
import com.techiteasy.TechItEasy.repositories.TelevisionRepository;
import com.techiteasy.TechItEasy.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {

        return ResponseEntity.ok(this.service.getAllTelevisions());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Television> getTelevisionById(@PathVariable Long id) {
//        Optional<Television> ot = this.repos.findById(id);
//
//        if (ot.isPresent()) {
//            return ResponseEntity.ok(ot.get());
//        } else {
//            throw new RecordNotFoundException("Television with id " + id + " not found");
//        }
//    }
//
    @PostMapping
    public ResponseEntity<TelevisionDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto televisionDto = this.service.createTelevision(televisionInputDto);

        return new ResponseEntity<>(televisionDto, HttpStatus.CREATED);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
//        Optional<Television> ot = this.repos.findById(id);
//        if (ot.isPresent()) {
//            Television existingTelevision = ot.get();
//
//            existingTelevision.setType(television.getType());
//            existingTelevision.setBrand(television.getBrand());
//            existingTelevision.setName(television.getName());
//            existingTelevision.setPrice(television.getPrice());
//            existingTelevision.setAvailableSize(television.getAvailableSize());
//            existingTelevision.setRefreshRate(television.getRefreshRate());
//            existingTelevision.setScreenType(television.getScreenType());
//            existingTelevision.setScreenQuality(television.getScreenQuality());
//            existingTelevision.setSmartTv(television.getSmartTv());
//            existingTelevision.setWifi(television.getWifi());
//            existingTelevision.setVoiceControl(television.getVoiceControl());
//            existingTelevision.setHdr(television.getHdr());
//            existingTelevision.setBluetooth(television.getBluetooth());
//            existingTelevision.setAmbiLight(television.getAmbiLight());
//            existingTelevision.setOriginalStock(television.getOriginalStock());
//            existingTelevision.setSold(television.getSold());
//            existingTelevision.setLastSold(television.getLastSold());
//            existingTelevision.setLastPurchased(television.getLastPurchased());
//
//            this.repos.save(existingTelevision);
//            return ResponseEntity.ok(existingTelevision);
//        } else {
//            throw new RecordNotFoundException("Television with id " + id + " not found");
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) {
//        Optional<Television> ot = this.repos.findById(id);
//
//        if (ot.isPresent()) {
//            this.repos.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            throw new RecordNotFoundException("Television with id " + id + " not found");
//        }
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Television> patchTelevision(@PathVariable Long id, @RequestBody Television television) {
//        Optional<Television> ot = this.repos.findById(id);
//
//        if (ot.isPresent()) {
//            Television existingTelevision = ot.get();
//
//            if (television.getType() != null) {
//                existingTelevision.setType(television.getType());
//            }
//
//            if (television.getBrand() != null) {
//                existingTelevision.setBrand(television.getBrand());
//            }
//
//            if (television.getName() != null) {
//                existingTelevision.setName(television.getName());
//            }
//
//            if (television.getPrice() != null) {
//                existingTelevision.setPrice(television.getPrice());
//            }
//
//            if (television.getAvailableSize() != null) {
//                existingTelevision.setAvailableSize(television.getAvailableSize());
//            }
//
//            if (television.getRefreshRate() != null) {
//                existingTelevision.setRefreshRate(television.getRefreshRate());
//            }
//
//            if (television.getScreenType() != null) {
//                existingTelevision.setScreenType(television.getScreenType());
//            }
//
//            if (television.getSmartTv() != null) {
//                existingTelevision.setSmartTv(television.getSmartTv());
//            }
//
//            if (television.getWifi() != null) {
//                existingTelevision.setWifi(television.getWifi());
//            }
//
//            if (television.getVoiceControl() != null) {
//                existingTelevision.setVoiceControl(television.getVoiceControl());
//            }
//
//            if (television.getHdr() != null) {
//                existingTelevision.setHdr(television.getHdr());
//            }
//
//            if (television.getBluetooth() != null) {
//                existingTelevision.setBluetooth(television.getBluetooth());
//            }
//
//            if (television.getAmbiLight() != null) {
//                existingTelevision.setAmbiLight(television.getAmbiLight());
//            }
//
//            if (television.getOriginalStock() != null) {
//                existingTelevision.setOriginalStock(television.getOriginalStock());
//            }
//
//            if (television.getSold() != null) {
//                existingTelevision.setSold(television.getSold());
//            }
//
//            if (television.getLastSold() != null) {
//                existingTelevision.setLastSold(television.getLastSold());
//            }
//
//            if (television.getLastPurchased() != null) {
//                existingTelevision.setLastPurchased(television.getLastPurchased());
//            }
//
//            this.repos.save(existingTelevision);
//            return ResponseEntity.ok(existingTelevision);
//        } else {
//            throw new RecordNotFoundException("Television with id " + id + " not found");
//        }
//    }
}