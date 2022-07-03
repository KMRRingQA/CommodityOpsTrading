package com.opstrader.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FutureDto {
    private LocalDate date;
    private Integer spec;
    private Long quantity;
    private BigDecimal price;
    private String hub;
}
