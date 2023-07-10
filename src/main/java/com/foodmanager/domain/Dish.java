package com.foodmanager.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kitchen_id", referencedColumnName = "id")
    private Kitchen kitchen;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "recipe")
    @ElementCollection
    private List<String> recipe;

    public Dish() {
    }

    public Dish(Long id, Kitchen kitchen, String name, String description, List<String> recipe) {
        this.id = id;
        this.kitchen = kitchen;
        this.name = name;
        this.description = description;
        this.recipe = recipe;
    }

    public Dish(Kitchen kitchen, String name, String description, List<String> recipe) {
        this.kitchen = kitchen;
        this.name = name;
        this.description = description;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public Kitchen getKitchen() {
        return kitchen;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecipe(List<String> recipe) {
        this.recipe = recipe;
    }
}
