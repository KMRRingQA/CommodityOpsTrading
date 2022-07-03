package com.opstrader.entities;

import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Future {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean buy;
    private LocalDate date;
    private Integer spec;
    private Long quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "hub_id")
    private Hub hub;

    @OneToMany(targetEntity = FutureBooking.class,cascade = CascadeType.ALL,mappedBy = "id",fetch = FetchType.LAZY)
    private List<FutureBooking> futureBookings;
}
