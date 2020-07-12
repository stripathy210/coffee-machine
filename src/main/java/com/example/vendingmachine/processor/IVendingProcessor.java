package com.example.vendingmachine.processor;

import com.example.vendingmachine.beverage.Beverage;
import com.example.vendingmachine.inventory.exceptions.NoInventoryException;
import com.example.vendingmachine.inventory.exceptions.SteamFailureException;

public interface IVendingProcessor {
    void mix(Beverage beverage) throws NoInventoryException;
    void heat(Beverage beverage) throws SteamFailureException;
}
