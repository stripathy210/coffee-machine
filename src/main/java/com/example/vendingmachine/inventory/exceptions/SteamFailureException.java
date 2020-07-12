package com.example.vendingmachine.inventory.exceptions;

/**
 * @author Shyam
 * Custom Defined exceptions, when Heater is not working in Vending machine
 */
public class SteamFailureException extends Exception {
    public SteamFailureException() {
        super("Cannot be heated Found");
    }
    public SteamFailureException(String msg) {
        super(msg);
    }
    public SteamFailureException(Exception exception) {
        super(exception);
    }
}
