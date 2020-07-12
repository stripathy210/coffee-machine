package com.example.vendingmachine.inventory;


import com.example.vendingmachine.ingredient.Ingredient;
import com.example.vendingmachine.inventory.exceptions.NoInventoryException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class IngredientInventory implements IInventory {

    private ReentrantLock lock = new ReentrantLock();
    private ConcurrentHashMap<String, Integer> inventory;

    public IngredientInventory() {
        inventory = new ConcurrentHashMap<>();
    }

    /**
     *
     * @param ingredientList
     * Updates the inventory.
     */
    @Override
    public void addInventory(List<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList){
            String inventoryKey = ingredient.getIngredientType().name();
            inventory.put(inventoryKey, inventory.getOrDefault(inventoryKey,0) + ingredient.getQuantity());
        }
    }

    /**
     *
     * @param ingredientList
     * @throws NoInventoryException
     *
     * There might be multiple threads trying to deduct the inventory and hence theres a lock.
     * Initially, validate if there's sufficient inventory in our map, if Yes, then go ahead and subtract it.
     */

    @Override
    public void deductInventory(List<Ingredient> ingredientList) throws NoInventoryException {
        try {
            lock.lock();
                for (Ingredient ingredient : ingredientList) {
                String inventoryKey = ingredient.getIngredientType().name();
                if (inventory.getOrDefault(inventoryKey, 0) < ingredient.getQuantity()) {
                    throw new NoInventoryException(ingredient.getIngredientType() + " is not available");
                }
            }

            for (Ingredient ingredient : ingredientList) {
                String inventoryKey = ingredient.getIngredientType().name();
                inventory.put(inventoryKey, inventory.getOrDefault(inventoryKey,0) - ingredient.getQuantity());
            }
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * To be implemented later
     */
    @Override
    public void getTotalInventory() {
    }

}
