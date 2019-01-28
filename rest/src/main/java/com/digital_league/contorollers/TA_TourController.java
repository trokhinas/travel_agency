package com.digital_league.contorollers;

import com.digital_league.DTO.TA_TourDTO;
import com.digital_league.Services.TA_TourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class TA_TourController {

    private final TA_TourService tourService;

    public TA_TourController(TA_TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/{id}")
    public TA_TourDTO get(@PathVariable("id") long id) {
        return tourService.getById(id);
    }

    @GetMapping("/all")
    public List<TA_TourDTO> getAll() {
        return tourService.getAll();
    }

    @PostMapping
    public boolean post(@RequestBody TA_TourDTO dto) {
        return tourService.create(dto);
    }

    @PutMapping
    public boolean put(@RequestBody TA_TourDTO dto) {
        return tourService.update(dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id) {
        return tourService.delete(id);
    }
}
