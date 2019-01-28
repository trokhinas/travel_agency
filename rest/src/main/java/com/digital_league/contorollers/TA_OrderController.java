package com.digital_league.contorollers;


import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.Services.TA_OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class TA_OrderController {

    private final TA_OrderService orderService;

    public TA_OrderController(TA_OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public TA_OrderDTO get(@PathVariable("id") long id) {
        return orderService.getById(id);
    }

    @GetMapping("/all")
    public List<TA_OrderDTO> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    public boolean post(@RequestBody TA_OrderDTO dto) {
        return orderService.create(dto);
    }

    @PutMapping
    public boolean put(@RequestBody TA_OrderDTO dto) {
        return orderService.update(dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id) {
        return orderService.delete(id);
    }
}
