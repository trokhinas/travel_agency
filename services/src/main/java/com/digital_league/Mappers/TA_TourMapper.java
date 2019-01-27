package com.digital_league.Mappers;

import com.digital_league.DTO.TA_TourDTO;
import com.digital_league.Entity.TA_TourEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface TA_TourMapper extends SimpleMapper<TA_TourEntity, TA_TourDTO> {

    @Override
    @Mappings({
            @Mapping(target = "tourId", ignore = true),
            @Mapping(target = "orders", ignore = true)
    })
    TA_TourEntity fromDTO(TA_TourDTO dto);

    @Override
    TA_TourDTO toDTO(TA_TourEntity entity);
}
