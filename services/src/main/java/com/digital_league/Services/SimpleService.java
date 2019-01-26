package com.digital_league.Services;

import java.util.List;

public interface SimpleService<DTO, ID> {

    public boolean create(DTO dto);
    public boolean delete(DTO dto);
    public boolean update(DTO dto);
    public DTO getById(ID id);
    public List<DTO> getAll();

}
