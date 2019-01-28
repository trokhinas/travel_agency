package com.digital_league.Services;

import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.DTO.TA_UserDTO;
import com.digital_league.Entity.TA_UserEntity;
import com.digital_league.Mappers.SimpleMapper;

import java.util.List;

public interface TA_UserService extends SimpleService<TA_UserDTO, Long>, SimpleMapper<TA_UserEntity, TA_UserDTO> {

    public boolean delete(Long id);
}
