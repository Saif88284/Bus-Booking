package com.bus.Repository;

import com.bus.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {

  boolean existsByUsername(String username);
  boolean existsByFirstName(String firstName);

  User findByContact(long contact);
}
