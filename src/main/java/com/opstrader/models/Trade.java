package com.opstrader.models;

import com.opstrader.entities.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trade {
    private Future sellFuture;
    private Future buyFuture1;
    private Future buyFuture2;
}
