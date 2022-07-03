package com.opstrader.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StorageBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date start;
    private Date end;
    private BigDecimal price;
    private long quantity;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
}
