package com.bus.ExceptionHandler;

import com.bus.Exception.*;
//import org.hibernate.grammars.hql.HqlParser;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@ControllerAdvice
public class GlobalExcption extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AdminException.class)
    private ResponseEntity<ErrorDetail> AdminExcption(
            AdminException e,
            WebRequest w
    ){
        ErrorDetail er = new ErrorDetail();
        er.setStatus("Error");
        er.setMessage(e.getMessage());
        er.setDate(new Date());
        er.setUri(w.getDescription(true));
        er.setLocalTime(LocalTime.now());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AdminloginExcption.class)
    private ResponseEntity<ErrorDetail> AdminExcption(
            AdminloginExcption e,
            WebRequest w
    ){
        ErrorDetail er = new ErrorDetail();
        er.setStatus("Error");
        er.setMessage(e.getMessage());
        er.setDate(new Date());
        er.setUri(w.getDescription(true));
        er.setLocalTime(LocalTime.now());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
 @ExceptionHandler(UserExcption.class)
    private ResponseEntity<ErrorDetail> UserExcption(
            UserExcption e,
            WebRequest w
    ){
        ErrorDetail er = new ErrorDetail();
        er.setStatus("Error");
        er.setMessage(e.getMessage());
        er.setDate(new Date());
        er.setUri(w.getDescription(true));
        er.setLocalTime(LocalTime.now());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserLoginExcption.class)
    private ResponseEntity<ErrorDetail> UserLoginExcption(
            UserLoginExcption e,
            WebRequest w
    ){
        ErrorDetail er = new ErrorDetail();
        er.setStatus("Error");
        er.setMessage(e.getMessage());
        er.setDate(new Date());
        er.setUri(w.getDescription(true));
        er.setLocalTime(LocalTime.now());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusExcption.class)
    private ResponseEntity<ErrorDetail> UserLoginExcption(
            BusExcption e,
            WebRequest w
    ){
        ErrorDetail er = new ErrorDetail();
        er.setStatus("Error");
        er.setMessage(e.getMessage());
        er.setDate(new Date());
        er.setUri(w.getDescription(true));
        er.setLocalTime(LocalTime.now());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }


}
