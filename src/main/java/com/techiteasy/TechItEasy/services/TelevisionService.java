package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.dtos.TelevisionDto;
import com.techiteasy.TechItEasy.dtos.TelevisionInputDto;
import com.techiteasy.TechItEasy.dtos.TelevisionPatchDto;
import com.techiteasy.TechItEasy.exceptions.RecordNotFoundException;
import com.techiteasy.TechItEasy.mappers.TelevisionMapper;
import com.techiteasy.TechItEasy.models.Television;
import com.techiteasy.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public TelevisionDto patchTelevision(Long id, TelevisionPatchDto televisionPatchDto) {
        Television existingTelevision = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));

        if (televisionPatchDto.type != null) {
            existingTelevision.setType(televisionPatchDto.type);
        }

        if (televisionPatchDto.brand != null) {
            existingTelevision.setBrand(televisionPatchDto.brand);
        }

        if (televisionPatchDto.name != null) {
            existingTelevision.setName(televisionPatchDto.name);
        }

        if (televisionPatchDto.price != null) {
            existingTelevision.setPrice(televisionPatchDto.price);
        }

        if (televisionPatchDto.availableSize != null) {
            existingTelevision.setAvailableSize(televisionPatchDto.availableSize);
        }

        if (televisionPatchDto.refreshRate != null) {
            existingTelevision.setRefreshRate(televisionPatchDto.refreshRate);
        }

        if (televisionPatchDto.screenType != null) {
            existingTelevision.setScreenType(televisionPatchDto.screenType);
        }

        if (televisionPatchDto.smartTv != null) {
            existingTelevision.setSmartTv(televisionPatchDto.smartTv);
        }

        if (televisionPatchDto.wifi != null) {
            existingTelevision.setWifi(televisionPatchDto.wifi);
        }

        if (televisionPatchDto.voiceControl != null) {
            existingTelevision.setVoiceControl(televisionPatchDto.voiceControl);
        }

        if (televisionPatchDto.hdr != null) {
            existingTelevision.setHdr(televisionPatchDto.hdr);
        }

        if (televisionPatchDto.bluetooth != null) {
            existingTelevision.setBluetooth(televisionPatchDto.bluetooth);
        }

        if (televisionPatchDto.ambiLight != null) {
            existingTelevision.setAmbiLight(televisionPatchDto.ambiLight);
        }

        if (televisionPatchDto.originalStock != null) {
            existingTelevision.setOriginalStock(televisionPatchDto.originalStock);
        }

        Television savedTelevision = televisionRepository.save(existingTelevision);
        return TelevisionMapper.toDto(savedTelevision);
    }
}
