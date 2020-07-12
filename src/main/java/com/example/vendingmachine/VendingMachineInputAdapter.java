package com.example.vendingmachine;

import com.example.vendingmachine.beverage.Beverage;
import com.example.vendingmachine.beverage.BeverageType;
import com.example.vendingmachine.ingredient.Ingredient;
import com.example.vendingmachine.ingredient.IngredientType;
import com.example.vendingmachine.input.Beverages;
import com.example.vendingmachine.input.BlackTea;
import com.example.vendingmachine.input.ElaichiTea;
import com.example.vendingmachine.input.GingerTea;
import com.example.vendingmachine.input.GreenTea;
import com.example.vendingmachine.input.HotCoffee;
import com.example.vendingmachine.input.HotMilk;
import com.example.vendingmachine.input.HotTea;
import com.example.vendingmachine.input.HotWater;
import com.example.vendingmachine.input.ItemInventory;
import com.example.vendingmachine.input.Machine;
import com.example.vendingmachine.input.ReqInputMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shyam
 * Adapter class, that takes the Input Json and maps to the POJO that the Vending Machine is defined.
 */
@Component
public class VendingMachineInputAdapter {

    private final ReqInputMapper reqInputMapper ;

    public VendingMachineInputAdapter(ReqInputMapper reqInputMapper) {
        this.reqInputMapper = reqInputMapper;
    }

    public VendingMachine getVendingMachine(String fileName) throws IOException {
        Machine machine = reqInputMapper.processInputJson(fileName);
        int cnt = machine.getOutlets().getCount();

        List<Ingredient> inventory = mapInventory(machine.getItemInventory());
        List<Beverage> beverages = mapBeverage(machine.getBeverages());

        return new VendingMachine(cnt, beverages, inventory);
    }

    private List<Ingredient> mapInventory(ItemInventory itemInventory) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_WATER).quantity(itemInventory.getHotWater()).build();
        Ingredient hotMilkIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_MILK).quantity(itemInventory.getHotMilk()).build();
        Ingredient gingerSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.GINGER_SYRUP).quantity(itemInventory.getGingerSyrup()).build();
        Ingredient sugarSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.SUGAR_SYRUP).quantity(itemInventory.getSugarSyrup()).build();
        Ingredient teaLeavesSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.TEA_LEAVES_SYRUP).quantity(itemInventory.getTeaLeavesSyrup()).build();
        Ingredient greenMixtureIngredient = Ingredient.builder().ingredientType(IngredientType.GREEN_MIXTURE).quantity(itemInventory.getGreenMixture()).build();
        Ingredient coffeeSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.COFFEE_SYRUP).quantity(itemInventory.getCoffeeSyrup()).build();
        Ingredient elaichiSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.ELAICHI_SYRUP).quantity(itemInventory.getElaichiSyrup()).build();

        ingredients.add(hotWaterIngredient);
        ingredients.add(hotMilkIngredient);
        ingredients.add(gingerSyrupIngredient);
        ingredients.add(sugarSyrupIngredient);
        ingredients.add(teaLeavesSyrupIngredient);
        ingredients.add(greenMixtureIngredient);
        ingredients.add(coffeeSyrupIngredient);
        ingredients.add(elaichiSyrupIngredient);

        return ingredients;
    }


    private List<Beverage> mapBeverage(Beverages beverages) {
        List<Beverage> beverageList = new ArrayList<>();

        if (beverages.getHotWater() != null) {
            beverageList.add(mapHotWater(beverages.getHotWater()));
        }

        if (beverages.getHotMilk() != null) {
            beverageList.add(mapHotMilk(beverages.getHotMilk()));
        }

        if (beverages.getHotTea() != null) {
            beverageList.add(mapTeaBeverage(beverages.getHotTea()));
        }
        if (beverages.getHotCoffee() != null) {
            beverageList.add(mapCoffeeBeverage(beverages.getHotCoffee()));
        }
        if (beverages.getGreenTea() != null) {
            beverageList.add(mapGreenTea(beverages.getGreenTea()));
        }

        if (beverages.getBlackTea() != null) {
            beverageList.add(mapBlackTea(beverages.getBlackTea()));
        }

        if (beverages.getElaichiTea() != null) {
            beverageList.add(mapElaichiTea(beverages.getElaichiTea()));
        }

        if (beverages.getGingerTea() != null) {
            beverageList.add(mapGingerTea(beverages.getGingerTea()));
        }

        return beverageList;
    }

    private  Beverage mapHotWater(HotWater hotWater) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_WATER).quantity(hotWater.getHotWater()).build();


        ingredients.add(hotWaterIngredient);

        return new Beverage(BeverageType.HOT_WATER, ingredients);
    }

    private  Beverage mapHotMilk(HotMilk hotMilk) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_MILK).quantity(hotMilk.getHotMilk()).build();


        ingredients.add(hotWaterIngredient);

        return new Beverage(BeverageType.HOT_MILK, ingredients);
    }

    private  Beverage mapTeaBeverage(HotTea hotTea) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_WATER).quantity(hotTea.getHotWater()).build();
        Ingredient hotMilkIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_MILK).quantity(hotTea.getHotMilk()).build();
        Ingredient gingerSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.GINGER_SYRUP).quantity(hotTea.getGingerSyrup()).build();
        Ingredient sugarSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.SUGAR_SYRUP).quantity(hotTea.getSugarSyrup()).build();
        Ingredient teaLeavesSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.TEA_LEAVES_SYRUP).quantity(hotTea.getTeaLeavesSyrup()).build();


        ingredients.add(hotWaterIngredient);
        ingredients.add(hotMilkIngredient);
        ingredients.add(gingerSyrupIngredient);
        ingredients.add(sugarSyrupIngredient);
        ingredients.add(teaLeavesSyrupIngredient);

        return new Beverage(BeverageType.HOT_TEA, ingredients);
    }

    private  Beverage mapCoffeeBeverage(HotCoffee hotCoffee) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_WATER).quantity(hotCoffee.getHotWater()).build();
        Ingredient hotMilkIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_MILK).quantity(hotCoffee.getHotMilk()).build();
        Ingredient gingerSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.GINGER_SYRUP).quantity(hotCoffee.getGingerSyrup()).build();
        Ingredient sugarSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.SUGAR_SYRUP).quantity(hotCoffee.getSugarSyrup()).build();
        Ingredient teaLeavesSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.TEA_LEAVES_SYRUP).quantity(hotCoffee.getTeaLeavesSyrup()).build();
        Ingredient coffeeSyrup = Ingredient.builder().ingredientType(IngredientType.COFFEE_SYRUP).quantity(hotCoffee.getCoffeeSyrup()).build();


        ingredients.add(hotWaterIngredient);
        ingredients.add(hotMilkIngredient);
        ingredients.add(gingerSyrupIngredient);
        ingredients.add(sugarSyrupIngredient);
        ingredients.add(teaLeavesSyrupIngredient);
        ingredients.add(coffeeSyrup);

        return new Beverage(BeverageType.HOT_COFFEE, ingredients);
    }

    private Beverage mapGreenTea(GreenTea greenTea) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_WATER).quantity(greenTea.getHotWater()).build();
        Ingredient gingerSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.GINGER_SYRUP).quantity(greenTea.getGingerSyrup()).build();
        Ingredient sugarSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.SUGAR_SYRUP).quantity(greenTea.getSugarSyrup()).build();
        Ingredient greenMixtureIngredient = Ingredient.builder().ingredientType(IngredientType.GREEN_MIXTURE).quantity(greenTea.getGreenMixture()).build();


        ingredients.add(hotWaterIngredient);
        ingredients.add(gingerSyrupIngredient);
        ingredients.add(sugarSyrupIngredient);
        ingredients.add(greenMixtureIngredient);

        return new Beverage(BeverageType.GREEN_TEA, ingredients);
    }

    private Beverage mapBlackTea(BlackTea blackTea) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_WATER).quantity(blackTea.getHotWater()).build();
        Ingredient gingerSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.GINGER_SYRUP).quantity(blackTea.getGingerSyrup()).build();
        Ingredient sugarSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.SUGAR_SYRUP).quantity(blackTea.getSugarSyrup()).build();
        Ingredient teaLeavesSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.TEA_LEAVES_SYRUP).quantity(blackTea.getTeaLeavesSyrup()).build();


        ingredients.add(hotWaterIngredient);
        ingredients.add(gingerSyrupIngredient);
        ingredients.add(sugarSyrupIngredient);
        ingredients.add(teaLeavesSyrupIngredient);

        return new Beverage(BeverageType.BLACK_TEA, ingredients);
    }

    private Beverage mapElaichiTea(ElaichiTea elaichiTea) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_WATER).quantity(elaichiTea.getHotWater()).build();
        Ingredient hotMilkIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_MILK).quantity(elaichiTea.getHotMilk()).build();
        Ingredient elaichiSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.GINGER_SYRUP).quantity(elaichiTea.getElaichiSyrup()).build();
        Ingredient sugarSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.SUGAR_SYRUP).quantity(elaichiTea.getSugarSyrup()).build();

        ingredients.add(hotWaterIngredient);
        ingredients.add(hotMilkIngredient);
        ingredients.add(sugarSyrupIngredient);
        ingredients.add(elaichiSyrupIngredient);

        return new Beverage(BeverageType.ELAICHI_TEA, ingredients);
    }

    private Beverage mapGingerTea(GingerTea gingerTea) {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient hotWaterIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_WATER).quantity(gingerTea.getHotWater()).build();
        Ingredient hotMilkIngredient = Ingredient.builder().ingredientType(IngredientType.HOT_MILK).quantity(gingerTea.getHotMilk()).build();
        Ingredient gingerSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.GINGER_SYRUP).quantity(gingerTea.getGingerSyrup()).build();
        Ingredient sugarSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.SUGAR_SYRUP).quantity(gingerTea.getSugarSyrup()).build();
        Ingredient teaLeavesSyrupIngredient = Ingredient.builder().ingredientType(IngredientType.TEA_LEAVES_SYRUP).quantity(gingerTea.getTeaLeavesSyrup()).build();


        ingredients.add(hotWaterIngredient);
        ingredients.add(gingerSyrupIngredient);
        ingredients.add(sugarSyrupIngredient);
        ingredients.add(teaLeavesSyrupIngredient);
        ingredients.add(hotMilkIngredient);

        return new Beverage(BeverageType.GINGER_TEA, ingredients);
    }

}
