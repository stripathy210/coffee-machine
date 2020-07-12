package com.example.vendingmachine.ingredient;

public enum IngredientType {
    HOT_WATER(0, "HOT_WATER"),
    HOT_MILK(1,"HOT_MILK"),
    GINGER_SYRUP(2,"GINGER_SYRUP"),
    SUGAR_SYRUP(3,"SUGAR_SYRUP"),
    COFFEE_SYRUP(4,"COFFEE_SYRUP"),
    ELAICHI_SYRUP(5,"ELAICHI_SYRUP"),
    TEA_LEAVES_SYRUP(6,"TEA_LEAVES_SYRUP"),
    GREEN_MIXTURE(7,"GREEN_MIXTURE");

    private String name;
    private Integer id;
    IngredientType(int id, String name) {
        this.name = name;
        this.id = id;
    }
}