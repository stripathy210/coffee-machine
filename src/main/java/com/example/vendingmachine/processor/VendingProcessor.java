package com.example.vendingmachine.processor;

import com.example.vendingmachine.beverage.Beverage;
import com.example.vendingmachine.inventory.IngredientInventory;
import com.example.vendingmachine.inventory.exceptions.NoInventoryException;
import com.example.vendingmachine.inventory.exceptions.SteamFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendingProcessor implements IVendingProcessor{

    private final IngredientInventory ingredientInventory;

    @Autowired
    public VendingProcessor(IngredientInventory ingredientInventory) {
        this.ingredientInventory = ingredientInventory;
    }

    /**
     *
     * @param beverage
     * @throws NoInventoryException
     */

    @Override
    public void mix(Beverage beverage) throws NoInventoryException {
        ingredientInventory.deductInventory(beverage.getIngredients());
    }

    @Override
    public void heat (Beverage beverage) throws SteamFailureException {
//        TODO implement this method
    }
}
