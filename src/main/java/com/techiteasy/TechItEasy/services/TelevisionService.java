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
        Television television = TelevisionMapper.toEntity(televisionInputDto);

        Television savedTelevision = televisionRepository.save(television);

        return TelevisionMapper.toDto(savedTelevision);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
        Television existingTelevision = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));

        existingTelevision.setType(televisionInputDto.type);
        existingTelevision.setBrand(televisionInputDto.brand);
        existingTelevision.setName(televisionInputDto.name);
        existingTelevision.setPrice(televisionInputDto.price);
        existingTelevision.setAvailableSize(televisionInputDto.availableSize);
        existingTelevision.setRefreshRate(televisionInputDto.refreshRate);
        existingTelevision.setScreenType(televisionInputDto.screenType);
        existingTelevision.setScreenQuality(televisionInputDto.screenQuality);
        existingTelevision.setSmartTv(televisionInputDto.smartTv);
        existingTelevision.setWifi(televisionInputDto.wifi);
        existingTelevision.setVoiceControl(televisionInputDto.voiceControl);
        existingTelevision.setHdr(televisionInputDto.hdr);
        existingTelevision.setBluetooth(televisionInputDto.bluetooth);
        existingTelevision.setAmbiLight(televisionInputDto.ambiLight);
        existingTelevision.setOriginalStock(televisionInputDto.originalStock);

        Television savedTelevision = televisionRepository.save(existingTelevision);
        return TelevisionMapper.toDto(savedTelevision);
    }

}
