package com.digital_league.Services;

import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.Entity.TA_OrderEntity;

public interface TA_OrderService extends SimpleService<TA_OrderDTO, Long>{

    public TA_OrderEntity fromDTO(TA_OrderDTO dto);
    public TA_OrderDTO toDTO(TA_OrderEntity entity);
}
