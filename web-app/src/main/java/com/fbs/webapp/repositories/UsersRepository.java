package com.fbs.webapp.repositories;

import org.springframework.stereotype.Repository;
import com.fbs.webapp.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
  /* ===== Method, retrieve user object by email address ===== */
  Users findByEmailAddress(String emailAddress);
}