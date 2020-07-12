package com.example.vendingmachine.beverage;

public enum BeverageType {
    HOT_TEA("HOT_TEA"),
    HOT_COFFEE("HOT_COFFEE"),
    BLACK_TEA("BLACK_TEA"),
    GREEN_TEA("GREEN_TEA"),
    ELAICHI_TEA("ELAICHI_TEA"),
    HOT_WATER("HOT_WATER"),
    HOT_MILK("HOT_MILK"),
    GINGER_TEA("GINGER_TEA");


    private String name;

    BeverageType(String name) {
        this.name = name;
    }

}
