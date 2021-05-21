package tech.itpark.carpshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.carpshop.manager.ClientManager;
import tech.itpark.carpshop.model.Boil;
import tech.itpark.carpshop.model.Client;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor

public class ClientController {
    private final ClientManager manager;

    @GetMapping
    public List<Client> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public Client getByBuyerId(@PathVariable long id) {
        return manager.getByBuyerId(id);
    }

    @PostMapping()
    public Client save(@RequestBody Client dto) {
        return manager.save(dto);
    }

    @PutMapping()
    public Client update(@RequestBody Client dto) {
        return manager.update(dto);
    }
}
