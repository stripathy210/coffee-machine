package com.example.vendingmachine.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
public class Beverages {
    private HotWater hotWater;
    private HotMilk hotMilk;
    private HotTea hotTea;
    private HotCoffee hotCoffee;
    private BlackTea blackTea;
    private GreenTea greenTea;
    private ElaichiTea elaichiTea;
    private GingerTea gingerTea;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Beverages{");
        sb.append("hotTea=").append(hotTea);
        sb.append(", hotCoffee=").append(hotCoffee);
        sb.append(", blackTea=").append(blackTea);
        sb.append(", greenTea=").append(greenTea);
        sb.append('}');
        return sb.toString();
    }
}
