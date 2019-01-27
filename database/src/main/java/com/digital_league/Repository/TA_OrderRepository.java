package com.digital_league.Repository;

import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.Entity.TA_OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TA_OrderRepository extends JpaRepository<TA_OrderEntity, Long> {

    public List<TA_OrderEntity> findAllByUser_UserId(Long id);
}
