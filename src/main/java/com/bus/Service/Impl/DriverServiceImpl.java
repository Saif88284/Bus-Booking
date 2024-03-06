//package com.bus.Service.Impl;
//
//import com.bus.Entity.Driver;
//import com.bus.Exception.DriverException;
//import com.bus.Payload.DriverDto;
//import com.bus.Repository.DriverRepository;
//import com.bus.Service.DriverService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DriverServiceImpl implements DriverService {
//
//    @Autowired
//    private DriverRepository driverRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//    @Override
//    public DriverDto addDriver(DriverDto dto) {
//        if (driverRepository.existsByAadharNumber(dto.getAadharNumber())){
//            throw new DriverException("driver alredy registered");
//        }
//        Driver driver = mapToEntity(dto);
//        Driver save = driverRepository.save(driver);
//        DriverDto driverDto = mapToDto(save);
//        return driverDto;
//    }
//
//    Driver mapToEntity(DriverDto dto){
//        return modelMapper.map(dto , Driver.class);
//    }
//    DriverDto mapToDto(Driver driver){
//        DriverDto dto  = new DriverDto();
//        dto.setDriverName(driver.getDriverName());
//        dto.setContact(driver.getContact());
//        return dto;
//    }
//}
