package tech.itpark.carpshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.carpshop.manager.BoilManager;
import tech.itpark.carpshop.model.Boil;

import java.util.List;

@RestController
@RequestMapping("/boils")
@RequiredArgsConstructor
public class BoilController {
    private final BoilManager manager;

    @GetMapping
    public List<Boil> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public Boil getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @GetMapping("/manufacturer/{manufacturerId}")
    public List<Boil> getByManufacturerId(@PathVariable long manufacturerId) {
        return manager.getByManufacturerId(manufacturerId);
    }

    @PostMapping
    public Boil save(@RequestBody Boil item) {
        return manager.save(item);
    }

    @DeleteMapping("/{id}")
    public Boil removeById(@PathVariable long id) {
        return manager.removeById(id);
    }

    @GetMapping("/search")
    public Boil search(@RequestParam String text) {
        return manager.search(text);
    }
}

