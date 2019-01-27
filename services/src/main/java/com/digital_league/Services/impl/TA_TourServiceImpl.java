package com.digital_league.Services.impl;

import com.digital_league.DTO.TA_TourDTO;
import com.digital_league.Entity.TA_TourEntity;
import com.digital_league.Mappers.SimpleMapper;
import com.digital_league.Mappers.TA_TourMapper;
import com.digital_league.Repository.TA_TourRepository;
import com.digital_league.Services.SimpleService;
import com.digital_league.Services.TA_TourService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TA_TourServiceImpl implements SimpleService<TA_TourDTO, Long>, SimpleMapper<TA_TourEntity, TA_TourDTO> {

    private final TA_TourRepository tourRepository;
    private final TA_TourMapper tourMapper;

    public TA_TourServiceImpl(TA_TourRepository tourRepository,
                              TA_TourMapper tourMapper) {
        this.tourRepository = tourRepository;
        this.tourMapper = tourMapper;
    }

    @Override
    public boolean create(TA_TourDTO dto) {
        var entity = fromDTO(dto);

        return tourRepository.save(entity) != null;
    }

    @Override
    public boolean delete(TA_TourDTO dto) {
        return delete(dto.getTourId());
    }

    private boolean delete(long id) {
        var entityOptional = tourRepository.findById(id);
        var wasDeleted = true;

        if(entityOptional.isPresent()) {
            tourRepository.delete(entityOptional.get());
        }
        else {
            wasDeleted = false;
        }

        return wasDeleted;
    }


    @Override
    public boolean update(TA_TourDTO dto) {
        var entityOptional = tourRepository.findById(dto.getTourId());
        var wasUpdated = true;

        if(entityOptional.isPresent()) {
            var entity = fromDTO(dto);
            entity.setTourId(dto.getTourId());

            tourRepository.save(entity);
        }
        else {
            wasUpdated = false;
        }

        return wasUpdated;
    }

    @Override
    public TA_TourDTO getById(Long id) {
        var entity = tourRepository.findById(id);
        TA_TourDTO dto;

        if(entity.isPresent()) {
            dto = toDTO(entity.get());
        }
        else throw new IllegalArgumentException("The object with such id do not exist");

        return dto;
    }

    @Override
    public List<TA_TourDTO> getAll() {
        List<TA_TourDTO> allTours;
        var stream = tourRepository.findAll().stream();

        allTours = stream.map(this::toDTO).collect(Collectors.toList());
        return allTours;
    }

    @Override
    public TA_TourEntity fromDTO(TA_TourDTO dto) {
        var entity = tourMapper.fromDTO(dto);

        return entity;
    }

    @Override
    public TA_TourDTO toDTO(TA_TourEntity entity) {
        var dto = tourMapper.toDTO(entity);

        return dto;
    }

}
