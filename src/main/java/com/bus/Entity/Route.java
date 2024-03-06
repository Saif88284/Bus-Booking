package com.bus.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long routeId;

    private String fromLacation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private String tolalDuration;
    @OneToOne
    @JoinColumn(name = "bus_Id")
    private Bus bus;

    @OneToMany(mappedBy = "route")
    private List<SubRoute> subRoutes;



//    public List<SubRoute> getSubRoutes() {
//        if (this.subRoutes == null) {
//            this.subRoutes = new ArrayList<>(); // Initialize the subRoutes list if it's null
//        }
//        return this.subRoutes;
//    }
}
