package com.example.vendingmachine.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
public class ItemInventory {
    private int hotWater;
    private int hotMilk;
    private int gingerSyrup;
    private int sugarSyrup;
    private int teaLeavesSyrup;
    private int greenMixture;
    private int coffeeSyrup;
    private int elaichiSyrup;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItemInventory{");
        sb.append("hotWater=").append(hotWater);
        sb.append(", hotMilk=").append(hotMilk);
        sb.append(", gingerSyrup=").append(gingerSyrup);
        sb.append(", sugarSyrup=").append(sugarSyrup);
        sb.append(", teaLeavesSyrup=").append(teaLeavesSyrup);
        sb.append(", greenMixture=").append(greenMixture);
        sb.append(", coffeeSyrup=").append(coffeeSyrup);
        sb.append(", elaichiSyrup=").append(elaichiSyrup);
        sb.append('}');
        return sb.toString();
    }
}
