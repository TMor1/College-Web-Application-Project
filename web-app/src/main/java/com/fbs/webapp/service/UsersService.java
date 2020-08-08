package com.fbs.webapp.service;

import com.fbs.webapp.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UsersService extends UserDetailsService{
  /* ===== Save New Users Method ===== */
  Users save(UsersDto usersDto);

}