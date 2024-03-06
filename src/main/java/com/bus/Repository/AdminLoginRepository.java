package com.bus.Repository;

import com.bus.CurrentSession.AdminCurrentSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLoginRepository extends JpaRepository<AdminCurrentSession, Long> {

    AdminCurrentSession findByUUId(String UUId);
}
