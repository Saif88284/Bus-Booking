package com.bus.Controller;

import com.bus.Payload.BusDto;
import com.bus.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/bus")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping
    private String addBus(@RequestBody BusDto dto) throws  Exception{
       busService.addBus(dto);
        return "Bus added";
    }
}



// SimpleDateFormat s = new SimpleDateFormat("DD-MM-YYYY");
//        Date fromDate = s.parse(dto.getFromDate());
//        Date toDate = s.parse(dto.getToDate());