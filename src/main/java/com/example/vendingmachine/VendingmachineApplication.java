package com.example.vendingmachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class VendingmachineApplication implements CommandLineRunner {

    @Autowired
    private VendingMachineExecutor vendingMachineExecutor;

    public static void main(String[] args) {
        SpringApplication.run(VendingmachineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            vendingMachineExecutor.execute("src/main/resources/VendingMachine.json");
            vendingMachineExecutor.execute("src/main/resources/VendingMachineAllParallel.json");
            vendingMachineExecutor.execute("src/main/resources/VendingMachineLongOrder.json");
            vendingMachineExecutor.execute("src/main/resources/VendingMachineNullInventory.json");
            vendingMachineExecutor.execute("src/main/resources/VendingMachineNullOrder.json");
            vendingMachineExecutor.execute("src/main/resources/VendingMachineOutOfStock.json");
            vendingMachineExecutor.execute("src/main/resources/VendingMachineSuccess2Outlets.json");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
