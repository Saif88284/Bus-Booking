package com.bus.Repository;

import com.bus.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver , Long> {
    boolean existsByAadharNumber(String aadharNumber);
}
