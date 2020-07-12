package com.example.vendingmachine.beverage;


import com.example.vendingmachine.ingredient.Ingredient;
import lombok.Getter;

import java.util.List;

/**
 * @author Shyam
 */

@Getter
public class Beverage  {
    private BeverageType beverageType;
    private List<Ingredient> ingredients;

    public Beverage(BeverageType beverageType, List<Ingredient> ingredients) {
        this.beverageType = beverageType;
        this.ingredients = ingredients;
    }
}
