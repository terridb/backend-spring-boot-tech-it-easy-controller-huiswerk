package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.models.Television;
import com.techiteasy.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getTelevisions() {
        List<Television> televisions =
    }

}
