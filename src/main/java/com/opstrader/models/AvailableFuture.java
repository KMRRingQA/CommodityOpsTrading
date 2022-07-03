package com.opstrader.models;

import com.opstrader.entities.Hub;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AvailableFuture {
    private Hub hub;
    private Integer spec;
}
