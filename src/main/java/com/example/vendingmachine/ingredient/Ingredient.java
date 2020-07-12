package com.example.vendingmachine.ingredient;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ingredient {
    private IngredientType ingredientType;
    private String quantityType;
    private int quantity;

}
