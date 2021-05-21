package tech.itpark.carpshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.carpshop.manager.OrderManager;
import tech.itpark.carpshop.model.Boil;
import tech.itpark.carpshop.model.Order;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderManager manager;

    @GetMapping
    public List<Order> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public Order getByOrderId(@PathVariable long id) {
        return manager.getByOrderId(id);
    }

    @PostMapping
    public Order save(@RequestBody Order dto) {
        return manager.save(dto);
    }

    @DeleteMapping("/{id}")
    public Order removeById(@PathVariable long id) {
        return manager.removeById(id);
    }

    @GetMapping("/search")
    public Order search(@RequestParam String text) {
        return manager.search(text);
    }
}

