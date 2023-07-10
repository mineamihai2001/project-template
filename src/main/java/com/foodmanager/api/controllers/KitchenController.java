package com.foodmanager.api.controllers;

import com.foodmanager.api.dtos.CreateKitchenDto;
import com.foodmanager.domain.Kitchen;
import com.foodmanager.infrastructure.repositories.KitchensRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("kitchens")
public class KitchenController {
    private final KitchensRepository kitchensRepository;

    public KitchenController(KitchensRepository kitchensRepository) {
        this.kitchensRepository = kitchensRepository;
    }

    @GetMapping()
    public List<Kitchen> getAll() {
        return this.kitchensRepository.findAll();
    }

    @PostMapping()
    public Kitchen create(@RequestBody() CreateKitchenDto dto) {
        return this.kitchensRepository.save(new Kitchen(dto.getName()));
    }
}
