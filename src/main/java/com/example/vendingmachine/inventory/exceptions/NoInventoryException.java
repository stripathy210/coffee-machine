package com.example.vendingmachine.inventory.exceptions;

/**
 * @author Shyam
 * Custom Defined exceptions, when inventory is out of stock
 */
public class NoInventoryException extends Exception {

    public NoInventoryException() {
        super("No Inventory Found");
    }
    public NoInventoryException(String msg) {
        super(msg);
    }
    public NoInventoryException(Exception exception) {
        super(exception);
    }
}
