package com.opstrader.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int duration;
    private BigDecimal price;
    private long capacity;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private Hub hubFrom;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private Hub hubTo;

    @OneToMany(targetEntity = TransportBooking.class,cascade = CascadeType.ALL,mappedBy = "id",fetch = FetchType.LAZY)
    private List<TransportBooking> transportBookings;
}
