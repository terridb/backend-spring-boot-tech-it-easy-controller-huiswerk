//package com.techiteasy.TechItEasy.controllers;
//
//import com.techiteasy.TechItEasy.dtos.CIModuleDto;
//import com.techiteasy.TechItEasy.dtos.CIModuleInputDto;
//import com.techiteasy.TechItEasy.services.CIModuleService;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/ci-modules")
//public class CIModuleController {
//
//    private final CIModuleService service;
//
//    public CIModuleController(CIModuleService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CIModuleDto>> getAllCIModules() {
//
//        return ResponseEntity.ok(this.service.getAllCIModules());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CIModuleDto> getCIModuleById(@PathVariable Long id) {
//        return ResponseEntity.ok(service.getCIModuleById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<CIModuleDto> createCIModule(@Valid @RequestBody CIModuleInputDto ciModuleInputDto) {
//        CIModuleDto ciModuleDto = this.service.createCIModule(ciModuleInputDto);
//
//        return new ResponseEntity<>(ciModuleDto, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CIModuleDto> updateCIModule(@PathVariable Long id, @Valid @RequestBody CIModuleInputDto ciModuleInputDto) {
//        CIModuleDto ciModuleDto = this.service.updateCIModule(id, ciModuleInputDto);
//
//        return ResponseEntity.ok(ciModuleDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCIModule(@PathVariable Long id) {
//        this.service.deleteCIModule(id);
//
//        return ResponseEntity.noContent().build();
//    }
//
//}
