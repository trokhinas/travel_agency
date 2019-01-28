package com.digital_league.Services;

import com.digital_league.DTO.TA_TourDTO;
import com.digital_league.Entity.TA_TourEntity;
import com.digital_league.Mappers.SimpleMapper;

public interface TA_TourService extends SimpleService<TA_TourDTO, Long>, SimpleMapper<TA_TourEntity, TA_TourDTO> {

    public boolean delete(Long id);
}
