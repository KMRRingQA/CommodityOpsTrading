package com.opstrader.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Combo {
    private AvailableFuture future1;
    private AvailableFuture future2;
}
