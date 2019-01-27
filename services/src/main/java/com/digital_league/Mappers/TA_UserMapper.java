package com.digital_league.Mappers;

import com.digital_league.DTO.TA_UserDTO;
import com.digital_league.Entity.TA_UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface TA_UserMapper extends SimpleMapper<TA_UserEntity, TA_UserDTO> {

    @Override
    @Mappings({
            @Mapping(target = "userId", ignore = true),
            @Mapping(target = "orders", ignore = true)
    })
    TA_UserEntity fromDTO(TA_UserDTO ta_userDTO);

    @Override
    TA_UserDTO toDTO(TA_UserEntity ta_userEntity);
}
