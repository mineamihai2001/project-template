package com.foodmanager.api.dtos;

public class CreateKitchenDto {

    private String name;

    public CreateKitchenDto() {
    }

    public CreateKitchenDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
