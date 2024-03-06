package com.bus.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDto {

    private long driverId;

    private String driverName;

    private String contact;
    private String aadharNumber;
    private String email;
    private String licNumber;
    private String address;
}
