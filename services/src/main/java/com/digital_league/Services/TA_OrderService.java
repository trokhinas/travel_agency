package com.digital_league.Services;

import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.DTO.TA_UserDTO;
import com.digital_league.Entity.TA_OrderEntity;
import com.digital_league.Mappers.SimpleMapper;

import java.util.List;

public interface TA_OrderService extends SimpleService<TA_OrderDTO, Long>, SimpleMapper<TA_OrderEntity, TA_OrderDTO> {

    public List<TA_OrderDTO> getAllOrdersByUser(TA_UserDTO dto);
}
