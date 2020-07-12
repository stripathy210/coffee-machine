package com.example.vendingmachine.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Machine {
    private Outlets outlets;
    @JsonProperty("total_items_quantity")
    private ItemInventory itemInventory;
    private Beverages beverages;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Machine{");
        sb.append("outlets=").append(outlets);
        sb.append(", ItemInventory=").append(itemInventory);
        sb.append(", beverages=").append(beverages);
        sb.append('}');
        return sb.toString();
    }
}
