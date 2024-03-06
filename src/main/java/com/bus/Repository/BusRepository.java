package com.bus.Repository;


import com.bus.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus , Long> {

    boolean existsByBusNumber(String busNumber);
}
