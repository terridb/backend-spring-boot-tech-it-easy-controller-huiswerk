package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.dtos.TelevisionDto;
import com.techiteasy.TechItEasy.dtos.TelevisionInputDto;
import com.techiteasy.TechItEasy.exceptions.RecordNotFoundException;
import com.techiteasy.TechItEasy.mappers.TelevisionMapper;
import com.techiteasy.TechItEasy.models.Television;
import com.techiteasy.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionDto> dtoTelevisions = new ArrayList<>();

        for (Television television : televisions) {
            dtoTelevisions.add(TelevisionMapper.toDto(television));
        }

        return dtoTelevisions;
    }

    public TelevisionDto getTelevisionById(Long id) {
        return TelevisionMapper.toDto(
                televisionRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found")));
    }

    public TelevisionDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television television = TelevisionMapper.toEntity(televisionInputDto, null);

        Television savedTelevision = televisionRepository.save(television);

        return TelevisionMapper.toDto(savedTelevision);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
        Television existingTelevision = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));

       Television updatedTelevision = TelevisionMapper.toEntity(televisionInputDto, existingTelevision);
        Television savedTelevision = televisionRepository.save(updatedTelevision);
        return TelevisionMapper.toDto(savedTelevision);
    }

    public void deleteTelevision(Long id) {
        televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));

        televisionRepository.deleteById(id);
    }

}
