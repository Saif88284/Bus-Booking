//package com.bus.Controller;
//
//import com.bus.Entity.Driver;
//import com.bus.Payload.DriverDto;
//import com.bus.Service.DriverService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@RestController
//public class DriverController {
//
//    @Autowired
//    private DriverService driverService;
//
//    @PostMapping("api/driver")
//    private DriverDto addDriver(DriverDto dto){
//      DriverDto dto1 =  driverService.addDriver(dto);
//      return dto1;
//    }
//}
