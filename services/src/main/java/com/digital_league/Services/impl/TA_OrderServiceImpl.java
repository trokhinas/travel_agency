package com.digital_league.Services.impl;

import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.DTO.TA_UserDTO;
import com.digital_league.Entity.TA_OrderEntity;
import com.digital_league.Mappers.TA_OrderMapper;
import com.digital_league.Repository.TA_OrderRepository;
import com.digital_league.Repository.TA_TourRepository;
import com.digital_league.Repository.TA_UserRepository;
import com.digital_league.Services.TA_OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TA_OrderServiceImpl implements TA_OrderService {


    private final TA_OrderRepository orderRepository;
    private final TA_UserRepository userRepository;
    private final TA_TourRepository tourRepository;
    private final TA_OrderMapper orderMapper;

    public TA_OrderServiceImpl(TA_OrderRepository orderRepository,
                               TA_UserRepository userRepository,
                               TA_TourRepository tourRepository,
                               TA_OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.tourRepository = tourRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public boolean create(TA_OrderDTO dto) {
        var entity = fromDTO(dto);

        return orderRepository.save(entity) != null;
    }

    @Override
    public boolean delete(TA_OrderDTO dto) {
        return delete(dto.getOrderId());
    }

    public boolean delete(Long id) {
        var entityOptional = orderRepository.findById(id);
        var wasDeleted = true;

        if(entityOptional.isPresent()) {
            orderRepository.delete(entityOptional.get());
        }
        else {
            wasDeleted = false;
        }

        return wasDeleted;
    }

    @Override
    public boolean update(TA_OrderDTO dto) {
        var entityOptional = orderRepository.findById(dto.getOrderId());
        var wasUpdated = true;

        if(entityOptional.isPresent()) {
            var entity = fromDTO(dto);
            entity.setOrderId(dto.getOrderId());

            orderRepository.save(entity);
        }
        else{
            wasUpdated = false;
        }

        return wasUpdated;
    }

    @Override
    public TA_OrderDTO getById(Long id) {
        var entity = orderRepository.findById(id);
        TA_OrderDTO dto;

        if(entity.isPresent()) {
            dto = toDTO(entity.get());
        }
        else throw new IllegalArgumentException("The object with such id do not exist");

        return dto;
    }

    @Override
    public List<TA_OrderDTO> getAll() {
        List<TA_OrderDTO> allOrders;
        var stream = orderRepository.findAll().stream();

        allOrders = stream.map(this::toDTO).collect(Collectors.toList());
        return allOrders;
    }

    @Override
    public List<TA_OrderDTO> getAllOrdersByUser(TA_UserDTO dto) {
        List<TA_OrderDTO> allUserOrders;
        var stream = orderRepository.findAllByUser_UserId(dto.getUserId()).stream();

        allUserOrders = stream.map(this::toDTO).collect(Collectors.toList());
        return allUserOrders;
    }


    @Override
    public TA_OrderEntity fromDTO(TA_OrderDTO dto) {
        var entity = orderMapper.fromDTO(dto);

        var tour = tourRepository.findById(dto.getTourId());
        var user = userRepository.findById(dto.getUserId());
        if(!tour.isPresent() || ! user.isPresent()) throw new IllegalArgumentException("The tour or user with such id do not exist");

        entity.setTour(tour.get());
        entity.setUser(user.get());

        return entity;
    }

    @Override
    public TA_OrderDTO toDTO(TA_OrderEntity entity) {
        var dto = orderMapper.toDTO(entity);

        var tourId = entity.getTour().getTourId();
        var userId = entity.getUser().getUserId();

        dto.setTourId(tourId);
        dto.setUserId(userId);

        return dto;
    }


}
