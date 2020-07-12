package com.example.vendingmachine.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Outlets {
    @JsonProperty("count_n")
    private int count;
}
