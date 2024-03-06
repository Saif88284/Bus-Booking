package com.bus.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRouteDto {
    private long subrouteId;
    private String fromLacation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String tolalDuration;
    private String fromTime;
    private String toTime;

}
