package com.bus.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SubRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long subrouteId;
    private String fromLacation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private String tolalDuration;

    @ManyToOne
    @JoinColumn(name = "route_Id")
    private Route route;
}
