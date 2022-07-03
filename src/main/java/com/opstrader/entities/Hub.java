package com.opstrader.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Future.class,cascade = CascadeType.ALL,mappedBy = "id",fetch = FetchType.LAZY)
    private List<Future> futures;

    @OneToMany(targetEntity = Storage.class,cascade = CascadeType.ALL,mappedBy = "id",fetch = FetchType.LAZY)
    private List<Storage> storages;

    @OneToMany(targetEntity = Transport.class,cascade = CascadeType.ALL,mappedBy = "hubFrom",fetch = FetchType.LAZY)
    private List<Transport> transportsTo;

    @OneToMany(targetEntity = Transport.class,cascade = CascadeType.ALL,mappedBy = "hubTo",fetch = FetchType.LAZY)
    private List<Transport> transportsFrom;

}
