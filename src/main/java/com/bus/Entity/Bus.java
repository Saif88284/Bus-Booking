package com.bus.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long busId;
    @Column(unique = true)
    private String busNumber;
    private String busName;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private LocalDateTime localDateTime;

    @OneToOne
    @JoinColumn(name = "route_Id")
    private Route route;


//    @OneToOne
//    @JoinColumn(name = "driver_Id")
//    private Driver driver;

}
// private String fromLacation;
//    private String toLocation;
//    private String fromDate;
//    private String toDate;
// private String fromTime;
//    private String toTime;