package com.digital_league.contorollers;

import com.digital_league.DTO.TA_OrderDTO;
import com.digital_league.DTO.TA_UserDTO;
import com.digital_league.Services.TA_OrderService;
import com.digital_league.Services.TA_UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class TA_UserController {

    private final TA_UserService userService;
    private final TA_OrderService orderService;

    public TA_UserController(TA_UserService userService,
                             TA_OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public TA_UserDTO get(@PathVariable("id") long id) {
        return userService.getById(id);
    }

    @GetMapping("/all")
    public List<TA_UserDTO> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}/orders/all")
    public List<TA_OrderDTO> getAllUserOrders(@PathVariable("id") long id) {
        var user = get(id);

        return orderService.getAllOrdersByUser(user);
    }

    @GetMapping("/{id}/orders/{orderId}")
    public TA_OrderDTO getUserOrder(@PathVariable("id") long id, @PathVariable("orderId") long orderId) {
        var user = get(id);

        var stream = getAllUserOrders(id).stream();
        var orderOptional = stream
                .filter(order -> order.getOrderId() == orderId)
                .findFirst();

        return orderOptional.get();
    }

    @PostMapping
    public boolean post(@RequestBody TA_UserDTO dto) {
        return userService.create(dto);
    }

    @PutMapping
    public boolean put(@RequestBody TA_UserDTO dto) {
        return userService.update(dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id) {
        return userService.delete(id);
    }
}
