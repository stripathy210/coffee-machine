package com.example.vendingmachine.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
public class HotCoffee {
    private int hotWater;
    private int hotMilk;
    private int gingerSyrup;
    private int sugarSyrup;
    private int teaLeavesSyrup;
    private int coffeeSyrup;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HotCoffee{");
        sb.append("hotWater=").append(hotWater);
        sb.append(", hotMilk=").append(hotMilk);
        sb.append(", gingerSyrup=").append(gingerSyrup);
        sb.append(", sugarSyrup=").append(sugarSyrup);
        sb.append(", teaLeavesSyrup=").append(teaLeavesSyrup);
        sb.append(", coffeeSyrup=").append(coffeeSyrup);
        sb.append('}');
        return sb.toString();
    }
}
