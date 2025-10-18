package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.dtos.televisions.TelevisionDto;
import com.techiteasy.TechItEasy.dtos.televisions.TelevisionInputDto;
import com.techiteasy.TechItEasy.dtos.televisions.TelevisionPatchDto;
import com.techiteasy.TechItEasy.dtos.televisions.TelevisionSalesDto;
import com.techiteasy.TechItEasy.exceptions.InvalidInputException;
import com.techiteasy.TechItEasy.exceptions.RecordNotFoundException;
import com.techiteasy.TechItEasy.mappers.TelevisionMapper;
import com.techiteasy.TechItEasy.models.CIModule;
import com.techiteasy.TechItEasy.models.RemoteController;
import com.techiteasy.TechItEasy.models.Television;
import com.techiteasy.TechItEasy.models.WallBracket;
import com.techiteasy.TechItEasy.repositories.CIModuleRepository;
import com.techiteasy.TechItEasy.repositories.RemoteControllerRepository;
import com.techiteasy.TechItEasy.repositories.TelevisionRepository;
import com.techiteasy.TechItEasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    private final RemoteControllerRepository remoteControllerRepository;

    private final CIModuleRepository ciModuleRepository;

    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository,
                             RemoteControllerRepository remoteControllerRepository,
                             CIModuleRepository ciModuleRepository,
                             WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
        this.wallBracketRepository = wallBracketRepository;
    }

    public TelevisionDto assignRemoteControllerToTelevision(Long televisionId, Long remoteControllerId) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + televisionId + " not found"));
        RemoteController remoteController = remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RecordNotFoundException("Remote controller with id " + remoteControllerId + " not found"));

        television.setRemoteController(remoteController);
        remoteController.setTelevision(television);

        Television savedTelevision = televisionRepository.save(television);

        return TelevisionMapper.toDto(savedTelevision);
    }

    public TelevisionDto assignCIModuleToTelevision(Long televisionId, Long ciModuleId) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + televisionId + " not found"));
        CIModule ciModule = ciModuleRepository.findById(ciModuleId)
                .orElseThrow(() -> new RecordNotFoundException("CI-Module with id " + ciModuleId + " not found"));

        television.setCiModule(ciModule);
        ciModule.getTelevisions().add(television);

        Television savedTelevision = televisionRepository.save(television);

        return TelevisionMapper.toDto(savedTelevision);
    }

    public TelevisionDto assignWallBracketToTelevision(Long televisionId, Long wallBracketId) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + televisionId + " not found"));
        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId)
                .orElseThrow(() -> new RecordNotFoundException("Wall bracket with id " + wallBracketId + " not found"));

        television.getWallBrackets().add(wallBracket);
        wallBracket.getTelevisions().add(television);

        Television savedTelevision = televisionRepository.save(television);

        return TelevisionMapper.toDto(savedTelevision);
    }

    public List<TelevisionSalesDto> getSalesAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionSalesDto> dtoTelevisions = new ArrayList<>();

        for (Television television : televisions) {
            dtoTelevisions.add(TelevisionMapper.toSalesDto(television));
        }

        return dtoTelevisions;
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
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));

        if (television.getRemoteController() != null) {
            RemoteController remoteController = television.getRemoteController();
            remoteController.setTelevision(null);
            television.setRemoteController(null);
            remoteControllerRepository.save(remoteController);
        }

        if (television.getCiModule() != null) {
            CIModule ciModule = television.getCiModule();
            ciModule.getTelevisions().remove(television);
            television.setCiModule(null);
            ciModuleRepository.save(ciModule);
        }

        if (television.getWallBrackets() != null) {
            for (WallBracket wallBracket : television.getWallBrackets()) {
                wallBracket.getTelevisions().remove(television);
            }
            television.getWallBrackets().clear();
        }

        televisionRepository.save(television);
        televisionRepository.delete(television);
    }

    public TelevisionDto patchTelevision(Long id, TelevisionPatchDto televisionPatchDto) {
        Television existingTelevision = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));

        if (televisionPatchDto.type != null) {
            if (televisionPatchDto.type.length() < 3 || televisionPatchDto.type.length() > 128) {
                throw new InvalidInputException("Type must be between 3 and 128 characters");
            }
            existingTelevision.setType(televisionPatchDto.type);
        }

        if (televisionPatchDto.brand != null) {
            if (televisionPatchDto.brand.length() < 3 || televisionPatchDto.brand.length() > 128) {
                throw new InvalidInputException("Brand must be between 3 and 128 characters");
            }
            existingTelevision.setBrand(televisionPatchDto.brand);
        }

        if (televisionPatchDto.name != null) {
            if (televisionPatchDto.name.length() < 3 || televisionPatchDto.name.length() > 128) {
                throw new InvalidInputException("Name must be between 3 and 128 characters");
            }
            existingTelevision.setName(televisionPatchDto.name);
        }

        if (televisionPatchDto.price != null) {
            if (televisionPatchDto.price < 0) {
                throw new InvalidInputException("Price must be a positive value");
            }

            String priceString = String.valueOf(televisionPatchDto.price);
            String[] parts = priceString.split("\\.");

            if (parts.length > 1 && parts[1].length() > 2) {
                throw new InvalidInputException("Price can not have more then 2 digits after the decimal");
            }

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

        if (televisionPatchDto.screenQuality != null) {
            existingTelevision.setScreenQuality(televisionPatchDto.screenQuality);
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
            if (televisionPatchDto.originalStock < 0) {
                throw new InvalidInputException("Stock must be greater than or equal to 0");
            }
            existingTelevision.setOriginalStock(televisionPatchDto.originalStock);
        }

        Television savedTelevision = televisionRepository.save(existingTelevision);
        return TelevisionMapper.toDto(savedTelevision);
    }
}
