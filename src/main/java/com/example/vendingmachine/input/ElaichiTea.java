package com.example.vendingmachine.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElaichiTea {
    private int hotWater;
    private int hotMilk;
    private int elaichiSyrup;
    private int sugarSyrup;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ElaichiTea{");
        sb.append("hotWater=").append(hotWater);
        sb.append(", hotMilk=").append(hotMilk);
        sb.append(", elaichiSyrup=").append(elaichiSyrup);
        sb.append(", sugarSyrup=").append(sugarSyrup);
        sb.append('}');
        return sb.toString();
    }

}
