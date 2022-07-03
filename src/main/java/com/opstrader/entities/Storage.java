package com.opstrader.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal price;
    private long capacity;

    @ManyToOne
    @JoinColumn(name = "hub_id")
    private Hub hub;

    @OneToMany(targetEntity = FutureBooking.class,cascade = CascadeType.ALL,mappedBy = "id",fetch = FetchType.LAZY)
    private List<StorageBooking> storageBookings;
}
