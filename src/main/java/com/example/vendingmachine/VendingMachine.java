package com.example.vendingmachine;

import com.example.vendingmachine.beverage.Beverage;
import com.example.vendingmachine.ingredient.Ingredient;
import lombok.Getter;

import java.util.List;

@Getter
public class VendingMachine {
    private int noOfOutlets;
    private List<Beverage> beverages;
    private List<Ingredient> itemInventory;

    public VendingMachine(int noOfOutlets, List<Beverage> beverages, List<Ingredient> itemInventory) {
        this.noOfOutlets = noOfOutlets;
        this.beverages = beverages;
        this.itemInventory = itemInventory;
    }
}
