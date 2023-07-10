package com.foodmanager.api.dtos;

import java.util.List;

public class CreateDishDto {
    private Long kitchenId;
    private String name;
    private String description;
    private List<String> recipe;

    public CreateDishDto(Long kitchenId, String name, String description, List<String> recipe) {
        this.kitchenId = kitchenId;
        this.name = name;
        this.description = description;
        this.recipe = recipe;
    }

    public Long getKitchenId() {
        return kitchenId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRecipe() {
        return recipe;
    }
}
