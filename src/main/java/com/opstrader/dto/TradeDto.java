package com.opstrader.dto;

import com.opstrader.entities.Future;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TradeDto {
    FutureDto sell;
    FutureDto buy1;
    FutureDto buy2;
}
