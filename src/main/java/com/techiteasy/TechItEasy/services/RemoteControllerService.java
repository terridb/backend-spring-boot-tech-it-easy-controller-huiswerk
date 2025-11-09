package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.dtos.remotecontrollers.RemoteControllerDto;
import com.techiteasy.TechItEasy.dtos.remotecontrollers.RemoteControllerInputDto;
import com.techiteasy.TechItEasy.exceptions.RecordNotFoundException;
import com.techiteasy.TechItEasy.mappers.RemoteControllerMapper;
import com.techiteasy.TechItEasy.models.RemoteController;
import com.techiteasy.TechItEasy.models.Television;
import com.techiteasy.TechItEasy.repositories.RemoteControllerRepository;
import com.techiteasy.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;
    private final TelevisionRepository televisionRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository, TelevisionRepository televisionRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
        this.televisionRepository = televisionRepository;
    }

    public List<RemoteControllerDto> getAllRemoteControllers() {
        List<RemoteController> remoteControllers = remoteControllerRepository.findAll();
        List<RemoteControllerDto> dtoRemoteControllers = new ArrayList<>();

        for (RemoteController remoteController : remoteControllers) {
            dtoRemoteControllers.add(RemoteControllerMapper.toDto(remoteController));
        }

        return dtoRemoteControllers;
    }

    public RemoteControllerDto getRemoteControllerById(Long id) {
        return RemoteControllerMapper.toDto(
                remoteControllerRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException("Remote controller with id " + id + " not found")));
    }

    public RemoteControllerDto createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController remoteController = RemoteControllerMapper.toEntity(remoteControllerInputDto, null);

        RemoteController savedRemoteController = remoteControllerRepository.save(remoteController);

        return RemoteControllerMapper.toDto(savedRemoteController);
    }

    public RemoteControllerDto updateRemoteController(Long id, RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController existingRemoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Remote controller with id " + id + " not found"));

        RemoteController updatedRemoteController = RemoteControllerMapper.toEntity(remoteControllerInputDto, existingRemoteController);
        RemoteController savedRemoteController = remoteControllerRepository.save(updatedRemoteController);
        return RemoteControllerMapper.toDto(savedRemoteController);
    }

    public void deleteRemoteController(Long id) {
        RemoteController remoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Remote controller with id " + id + " not found"));

        if (remoteController.getTelevision() != null) {
            Television television = remoteController.getTelevision();
            television.setRemoteController(null);
            remoteController.setTelevision(null);
            televisionRepository.save(television);
        }

        remoteControllerRepository.delete(remoteController);
    }
}
