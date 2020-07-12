package com.example.vendingmachine.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreenTea {
    private int hotWater;
    private int gingerSyrup;
    private int sugarSyrup;
    private int greenMixture;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GreenTea{");
        sb.append("hotWater=").append(hotWater);
        sb.append(", gingerSyrup=").append(gingerSyrup);
        sb.append(", sugarSyrup=").append(sugarSyrup);
        sb.append(", greenMixture=").append(greenMixture);
        sb.append('}');
        return sb.toString();
    }
}
