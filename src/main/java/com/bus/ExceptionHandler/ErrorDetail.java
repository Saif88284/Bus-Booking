package com.bus.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {
    private String status;
    private String message;
    private Date date;
    private String uri;
    private LocalTime localTime;

    public ErrorDetail(LocalTime localTime) {
        this.localTime = localTime;
    }
}
