package com.digital_league.Mappers;

import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.Entity.TA_OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")

public interface TA_OrderMapper extends SimpleMapper<TA_OrderEntity, TA_OrderDTO>{

    @Override
    @Mappings({
            @Mapping(target = "orderId", ignore = true),
            @Mapping(target = "tour", ignore = true),
            @Mapping(target = "user", ignore = true)
    })
    TA_OrderEntity fromDTO(TA_OrderDTO dto);

    @Mappings({
            @Mapping(target = "tourId", ignore = true),
            @Mapping(target = "userId", ignore = true)
    })
    @Override
    TA_OrderDTO toDTO(TA_OrderEntity entity);
}
