package com.digital_league.Services.impl;

import com.digital_league.DTO.TA_UserDTO;
import com.digital_league.Entity.TA_UserEntity;
import com.digital_league.Mappers.TA_UserMapper;
import com.digital_league.Repository.TA_UserRepository;
import com.digital_league.Services.TA_UserService;

import java.util.List;
import java.util.stream.Collectors;

public class TA_UserServiceImpl implements TA_UserService {

    private final TA_UserRepository userRepository;
    private final TA_UserMapper userMapper;

    public TA_UserServiceImpl(TA_UserRepository userRepository,
                              TA_UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean create(TA_UserDTO dto) {
        var entity = fromDTO(dto);

        return userRepository.save(entity) != null;
    }

    @Override
    public boolean delete(TA_UserDTO dto) {
        return delete(dto.getUserId());
    }

    private boolean delete(long id) {
        var entityOptional = userRepository.findById(id);
        var wasDeleted = true;

        if(entityOptional.isPresent()) {
            userRepository.delete(entityOptional.get());
        }
        else {
            wasDeleted = false;
        }

        return wasDeleted;
    }

    @Override
    public boolean update(TA_UserDTO dto) {
        var entityOptional = userRepository.findById(dto.getUserId());
        var wasUpdated = true;

        if(entityOptional.isPresent()) {
            var entity = fromDTO(dto);
            entity.setUserId(dto.getUserId());

            userRepository.save(entity);
        }
        else {
            wasUpdated = false;
        }

        return wasUpdated;
    }

    @Override
    public TA_UserDTO getById(Long id) {
        var entity = userRepository.findById(id);
        TA_UserDTO dto;

        if(entity.isPresent()) {
            dto = toDTO(entity.get());
        }
        else throw new IllegalArgumentException("The object with such id do not exist");

        return dto;
    }

    @Override
    public List<TA_UserDTO> getAll() {
        List<TA_UserDTO> allUsers;
        var stream = userRepository.findAll().stream();

        allUsers = stream.map(this::toDTO).collect(Collectors.toList());
        return allUsers;
    }


    @Override
    public TA_UserEntity fromDTO(TA_UserDTO dto) {
        var entity = userMapper.fromDTO(dto);

        return entity;
    }

    @Override
    public TA_UserDTO toDTO(TA_UserEntity entity) {
        var dto = userMapper.toDTO(entity);

        return dto;
    }


}
