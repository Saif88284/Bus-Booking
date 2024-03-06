package com.bus.Payload;

import com.bus.Entity.Route;
import com.bus.Entity.SubRoute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BusDto {
    private long busId;
    private String busNumber;
    private String busName;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private LocalDateTime localDateTime;
    private RouteDto route;
    private List<SubRouteDto> subRoute;
//    private Driver driver;


}
