package com.example.vendingmachine.processor;


import com.example.vendingmachine.beverage.Beverage;
import com.example.vendingmachine.inventory.exceptions.NoInventoryException;
import com.example.vendingmachine.inventory.exceptions.SteamFailureException;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class AsyncVendingProcessor implements Callable<Integer> {

    private Beverage beverage;
    private IVendingProcessor vendingProcessor;
    private CountDownLatch latch;
    private final static int TIME_FOR_BEVERAGE =  1000;

    public AsyncVendingProcessor(Beverage beverage, IVendingProcessor vendingProcessor, CountDownLatch latch) {
        this.beverage = beverage;
        this.vendingProcessor = vendingProcessor;
        this.latch = latch;
    }

    @Override
    public Integer call() throws InterruptedException {
        try {
            vendingProcessor.mix(beverage);
            vendingProcessor.heat(beverage);
            Thread.sleep(TIME_FOR_BEVERAGE);

            System.out.println(beverage.getBeverageType() + " is prepared");
        } catch (NoInventoryException | SteamFailureException e) {
            System.out.println(beverage.getBeverageType() + " cannot be prepared because " + e.getMessage());
        }

        latch.countDown();
        return 1;
    }
}
