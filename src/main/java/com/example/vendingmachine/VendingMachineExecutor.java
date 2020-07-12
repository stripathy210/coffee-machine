package com.example.vendingmachine;

import com.example.vendingmachine.beverage.Beverage;
import com.example.vendingmachine.inventory.IngredientInventory;
import com.example.vendingmachine.processor.AsyncVendingProcessor;
import com.example.vendingmachine.processor.VendingProcessor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class VendingMachineExecutor {
    private final static int MAX_THREADS = 20;
    private final VendingMachineInputAdapter vendingMachineInputAdapter;
    private final VendingProcessor vendingProcessor;
    private final IngredientInventory ingredientInventory;

    public VendingMachineExecutor(VendingMachineInputAdapter vendingMachineInputAdapter, VendingProcessor vendingProcessor, IngredientInventory ingredientInventory) {
        this.vendingMachineInputAdapter = vendingMachineInputAdapter;
        this.vendingProcessor = vendingProcessor;
        this.ingredientInventory = ingredientInventory;
    }

    public void execute(String fileName) throws IOException, InterruptedException {
        VendingMachine vendingMachine = vendingMachineInputAdapter.getVendingMachine(fileName);
        ingredientInventory.addInventory(vendingMachine.getItemInventory());

        CountDownLatch vendingLatch = new CountDownLatch(vendingMachine.getBeverages().size());
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(vendingMachine.getNoOfOutlets(), MAX_THREADS));

//        Thread.sleep(5000);
        System.out.println("----------- Vending Machine Processing started ----------- for " + fileName);

        for (Beverage beverage : vendingMachine.getBeverages()) {
            AsyncVendingProcessor asyncVendingProcessor = new AsyncVendingProcessor(beverage, vendingProcessor,vendingLatch);
            executorService.submit(asyncVendingProcessor);
        }

        vendingLatch.await();
        System.out.println("----------- Vending Machine Processing ended ----------- for " + fileName);
        executorService.shutdownNow();


    }
}
