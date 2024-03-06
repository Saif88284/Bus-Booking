package com.bus.Service.Impl;

import com.bus.Entity.Bus;
import com.bus.Entity.Route;
import com.bus.Entity.SubRoute;
import com.bus.Exception.BusExcption;
import com.bus.Payload.BusDto;
import com.bus.Payload.SubRouteDto;
import com.bus.Repository.BusRepository;
import com.bus.Repository.DriverRepository;
import com.bus.Repository.RouteRepository;
import com.bus.Repository.SubRouteRepository;
import com.bus.Service.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RouteRepository routeRepository;


    @Autowired
    private SubRouteRepository subrouteRepository;
    @Autowired
    private ModelMapper modelMapper;

    Bus mapToEntity (BusDto dto){
        return modelMapper.map(dto, Bus.class);
    }
    BusDto mapToDto (Bus bus){
        return modelMapper.map(bus, BusDto.class);
    }

    @Override
    public void addBus(BusDto dto) {
        Route route = new Route();
        route.setFromLacation(dto.getRoute().getFromLacation());
        route.setToLocation(dto.getRoute().getToLocation());
        route.setFromDate(dto.getRoute().getFromDate());
        route.setToDate(dto.getRoute().getToDate());
        route.setFromTime(dto.getRoute().getFromTime());
        route.setToTime(dto.getRoute().getToTime());
        route.setTolalDuration(dto.getRoute().getTolalDuration());

        Route saveRoute = routeRepository.save(route);

        if (busRepository.existsByBusNumber(dto.getBusNumber())) {
            throw new BusExcption(dto.getBusNumber() + " Bus is alredy added");
        }

//        Bus bus = new Bus();
//        bus.setBusNumber(dto.getBusNumber());
//        bus.setBusName(dto.getBusName());
//        bus.setBusType(dto.getBusType());
//        bus.setPrice(dto.getPrice());
//        bus.setTotalSeats(dto.getTotalSeats());
//        bus.setAvailableSeats(dto.getAvailableSeats());
        Bus bus = mapToEntity(dto);
        bus.setRoute(route);
        Bus saveBus = busRepository.save(bus);

        Route routeUpdate = routeRepository.findById(saveRoute.getRouteId()).get();
        routeUpdate.setBus(saveBus);
        routeRepository.save(routeUpdate);

        if (dto.getSubRoute() != null && dto.getSubRoute().isEmpty()) {
            for (SubRouteDto subRouteDto : dto.getSubRoute()){
            SubRoute subRoute = new SubRoute();
            subRoute.setFromLacation(subRouteDto.getFromLacation());
            subRoute.setToLocation(subRouteDto.getToLocation());
            subRoute.setFromDate(subRouteDto.getFromDate());
            subRoute.setToDate(subRouteDto.getToDate());
            subRoute.setFromTime(subRouteDto.getFromTime());
            subRoute.setToTime(subRouteDto.getToTime());
            subRoute.setTolalDuration(subRouteDto.getTolalDuration());
            //Associate SubRoute with entity
            subRoute.setRoute(route);
            subrouteRepository.save(subRoute);

        }
        }

    }
}

// if (busRepository.existsByBusNumber(dto.getBusNumber())){
//                throw new BusExcption( dto.getBusNumber()+ " Bus is alredy added");
//        }

//Bus bus = mapToEntity(dto);
//        bus.setLocalDateTime(LocalDateTime.now());
//Bus save = busRepository.save(bus);
//mapToDto(save);
//        return dto;



//        if (dto.getSubRoute() != null) {
//            for (SubRoute subRouteDto : dto.getRoute().getSubRoutes()) {
//                SubRoute subRoute = new SubRoute();
//                subRoute.setFromLacation(dto.subRouteDto.getFromLacation());
//                subRoute.setToLocation(subRouteDto.getToLocation());
//                subRoute.setFromDate(subRouteDto.getFromDate());
//                subRoute.setToDate(subRouteDto.getToDate());
//                subRoute.setFromTime(subRouteDto.getFromTime());
//                subRoute.setToTime(subRouteDto.getToTime());
//                subRoute.setTolalDuration(subRouteDto.getTolalDuration());
//                subRoute.setRoute(route);
//                subrouteRepository.save(subRoute);
//            }
//        }




//        if (dto.getSubRoute()!= null){
//            for (SubRoute subRoute : dto.getRoute().get){
//            SubRoute subRoute = new SubRoute();
//                subRoute.setFromLacation(dto.subRouteDto().getFromLacation());
//                subRoute.setToLocation(dto.getSubRoute().getToLocation());
//                subRoute.setFromDate(dto.getSubRoute().getFromDate());
//                subRoute.setToDate(dto.getSubRoute().getToDate());
//                subRoute.setFromTime(dto.getSubRoute().getFromTime());
//                subRoute.setToTime(dto.getSubRoute().getToTime());
//                subRoute.setTolalDuration(dto.getSubRoute().getTolalDuration());
//                //Associate SubRoute with entity
//                subRoute.setRoute(route);
//                subrouteRepository.save(subRoute);
//
//            }
//        }