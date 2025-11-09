package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.dtos.wallbrackets.WallBracketDto;
import com.techiteasy.TechItEasy.dtos.wallbrackets.WallBracketInputDto;
import com.techiteasy.TechItEasy.exceptions.RecordNotFoundException;
import com.techiteasy.TechItEasy.mappers.WallBracketMapper;
import com.techiteasy.TechItEasy.models.Television;
import com.techiteasy.TechItEasy.models.WallBracket;
import com.techiteasy.TechItEasy.repositories.TelevisionRepository;
import com.techiteasy.TechItEasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;
    private final TelevisionRepository televisionRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository, TelevisionRepository televisionRepository) {
        this.wallBracketRepository = wallBracketRepository;
        this.televisionRepository = televisionRepository;
    }

    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wallBrackets = wallBracketRepository.findAll();
        List<WallBracketDto> dtoWallBrackets = new ArrayList<>();

        for (WallBracket wallBracket : wallBrackets) {
            dtoWallBrackets.add(WallBracketMapper.toDto(wallBracket));
        }

        return dtoWallBrackets;
    }

    public WallBracketDto getWallBracketById(Long id) {
        return WallBracketMapper.toDto(
                wallBracketRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException("Wall bracket with id " + id + " not found")));
    }

    public WallBracketDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = WallBracketMapper.toEntity(wallBracketInputDto, null);

        WallBracket savedWallBracket = wallBracketRepository.save(wallBracket);

        return WallBracketMapper.toDto(savedWallBracket);
    }

    public WallBracketDto updateWallBracket(Long id, WallBracketInputDto wallBracketInputDto) {
        WallBracket existingWallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Wall bracket with id " + id + " not found"));

        WallBracket updatedWallBracket = WallBracketMapper.toEntity(wallBracketInputDto, existingWallBracket);
        WallBracket savedWallBracket = wallBracketRepository.save(updatedWallBracket);
        return WallBracketMapper.toDto(savedWallBracket);
    }

    public void deleteWallBracket(Long id) {
        WallBracket wallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Wall bracket with id " + id + " not found"));

        if (wallBracket.getTelevisions() != null) {
            for (Television television : wallBracket.getTelevisions()) {
                television.getWallBrackets().remove(wallBracket);
                televisionRepository.save(television);
            }
            wallBracket.getTelevisions().clear();
        }

        wallBracketRepository.delete(wallBracket);
    }
}
