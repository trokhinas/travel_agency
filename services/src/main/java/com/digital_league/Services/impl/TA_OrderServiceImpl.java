package com.digital_league.Services.impl;

import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.Entity.TA_OrderEntity;
import com.digital_league.Repository.TA_OrderRepository;
import com.digital_league.Services.TA_OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TA_OrderServiceImpl implements TA_OrderService {


    private final TA_OrderRepository orderRepository;

    public TA_OrderServiceImpl(TA_OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean create(TA_OrderDTO dto) {
        TA_OrderEntity entity = fromDTO(dto);

        return orderRepository.save(entity) != null;
    }

    @Override
    public boolean delete(TA_OrderDTO dto) {
        return false;
    }

    @Override
    public boolean update(TA_OrderDTO dto) {
        return false;
    }

    @Override
    public TA_OrderDTO getById(Long aLong) {
        return null;
    }

    @Override
    public List<TA_OrderDTO> getAll() {
        return null;
    }


    @Override
    public TA_OrderEntity fromDTO(TA_OrderDTO dto) {
        return null;
    }

    @Override
    public TA_OrderDTO toDTO(TA_OrderEntity entity) {
        return null;
    }
}
