package com.digital_league.Mappers;


public interface SimpleMapper<Entity, DTO> {

    public Entity fromDTO(DTO dto);
    public DTO toDTO(Entity entity);
}
