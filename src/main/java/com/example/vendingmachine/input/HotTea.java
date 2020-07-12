package com.example.vendingmachine.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotTea {
    private int hotWater;
    private int hotMilk;
    private int gingerSyrup;
    private int sugarSyrup;
    private int teaLeavesSyrup;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HotTea{");
        sb.append("hotWater=").append(hotWater);
        sb.append(", hotMilk=").append(hotMilk);
        sb.append(", gingerSyrup=").append(gingerSyrup);
        sb.append(", sugarSyrup=").append(sugarSyrup);
        sb.append(", teaLeavesSyrup=").append(teaLeavesSyrup);
        sb.append('}');
        return sb.toString();
    }
}
