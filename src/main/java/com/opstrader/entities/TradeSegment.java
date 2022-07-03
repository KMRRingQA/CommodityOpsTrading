package com.opstrader.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TradeSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_booking_id")
    private FutureBooking futureBooking;

    @ManyToOne
    @JoinColumn(name = "storage_booking_id")
    private StorageBooking storageBooking;

    @ManyToOne
    @JoinColumn(name = "transport_booking_id")
    private TransportBooking transportBooking;

    @ManyToOne
    @JoinColumn(name = "trade_plan_id")
    private TradePlan tradePlan;

    private boolean mix;
    private Date start;
    private Date end;
    private String type;

}
