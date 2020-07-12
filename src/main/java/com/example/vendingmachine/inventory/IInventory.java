package com.example.vendingmachine.inventory;

import com.example.vendingmachine.ingredient.Ingredient;
import com.example.vendingmachine.inventory.exceptions.NoInventoryException;

import java.util.List;

public interface IInventory {

    void addInventory(List<Ingredient> ingredientList);
    void deductInventory(List<Ingredient> ingredientList) throws NoInventoryException;
    void getTotalInventory();
}
