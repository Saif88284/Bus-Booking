package com.bus.Repository;

import com.bus.CurrentSession.UserCurrentSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRespository extends JpaRepository<UserCurrentSession, Long> {

    Boolean existsByUserId(long userId);
}
