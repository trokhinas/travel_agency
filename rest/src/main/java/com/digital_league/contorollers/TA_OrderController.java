package com.digital_league.contorollers;


import com.digital_league.Services.TA_OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class TA_OrderController {

    private final TA_OrderService orderService;

    public TA_OrderController(TA_OrderService orderService) {
        this.orderService = orderService;
    }
}
