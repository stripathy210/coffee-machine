package com.example.vendingmachine.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlackTea {
    private int hotWater;
    private int gingerSyrup;
    private int sugarSyrup;
    private int teaLeavesSyrup;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BlackTea{");
        sb.append("hotWater=").append(hotWater);
        sb.append(", gingerSyrup=").append(gingerSyrup);
        sb.append(", sugarSyrup=").append(sugarSyrup);
        sb.append(", teaLeavesSyrup=").append(teaLeavesSyrup);
        sb.append('}');
        return sb.toString();
    }
}
