package com.techiteasy.TechItEasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final List<String> televisionDataBase = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<String>> getAllTelevisions() {
        return ResponseEntity.ok(this.televisionDataBase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable int id) {
        return ResponseEntity.ok(this.televisionDataBase.get(id));
    }

    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String television) {
        this.televisionDataBase.add(television);

        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String television) {
        this.televisionDataBase.set(id, television);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        this.televisionDataBase.remove(id);

        return ResponseEntity.noContent().build();
    }
}

