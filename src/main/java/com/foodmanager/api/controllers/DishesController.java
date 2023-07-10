package com.foodmanager.api.controllers;

import com.foodmanager.api.dtos.CreateDishDto;
import com.foodmanager.domain.Dish;
import com.foodmanager.domain.Kitchen;
import com.foodmanager.infrastructure.repositories.DishesRepository;
import com.foodmanager.infrastructure.repositories.KitchensRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dishes")
public class DishesController {
    private final DishesRepository dishesRepository;
    private final KitchensRepository kitchensRepository;

    public DishesController(DishesRepository dishesRepository, KitchensRepository kitchensRepository) {
        this.dishesRepository = dishesRepository;
        this.kitchensRepository = kitchensRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Dish>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.dishesRepository.findAll());
    }

    @GetMapping("random")
    public ResponseEntity<Dish> getRandom() {
        long max = this.dishesRepository.count();
        double randomIndex = Math.random() * max - 1;

        Optional<Dish> dish = this.dishesRepository.findById((long) randomIndex);
        return dish.map(value -> ResponseEntity
                .status(200)
                .body(value)).orElse(null);

    }

    @PostMapping()
    public ResponseEntity<Dish> create(@RequestBody() CreateDishDto dto) {
        Optional<Kitchen> kitchen = this.kitchensRepository.findById(dto.getKitchenId());
        if (kitchen.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.dishesRepository.save(new Dish(kitchen.get(), dto.getName(),
                        dto.getDescription(), dto.getRecipe())));
    }
}
