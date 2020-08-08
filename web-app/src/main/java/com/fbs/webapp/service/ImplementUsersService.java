package com.fbs.webapp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import com.fbs.webapp.entities.Roles;
import com.fbs.webapp.entities.Users;
import com.fbs.webapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ImplementUsersService implements UsersService {

  /* ===== Call User Repository ===== */
  private UsersRepository usersRepository;

  public ImplementUsersService(UsersRepository usersRepository){
    this.usersRepository = usersRepository;
  }

  /* ===== Implement Hash/Salt Method ===== */
  @Autowired
  private BCryptPasswordEncoder passwordHash;

  /* ===== Implement Save Method ===== */
  @Override
  public Users save(UsersDto usersDto) {
    Users users= new Users(
      usersDto.getLastName(), 
      usersDto.getFirstName(),
      usersDto.getEmailAddress(),
      passwordHash.encode(usersDto.getPassword()), 
      Arrays.asList(new Roles("ROLE_USER")));
    return usersRepository.save(users);
  }

  /* Impliment/Map Functions Below, Learned from: Java Guides - Listed in References in the Techinal Report */
  /* ===== Implement Load User Method  ===== */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users users = usersRepository.findByEmailAddress(username);
    if(users == null){
      throw new UsernameNotFoundException("Incorrect username or password.");
    }
    /* ===== If User not null create a user object via spring security ===== */
		return new org.springframework.security.core.userdetails.User(users.getEmailAddress(), users.getPassword(), mapRolesToAuthorities(users.getRole()));	
  }

  /* ===== Map Roles to Authorities  ===== */
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Roles> roles){
		return roles.stream().map(Roles -> new SimpleGrantedAuthority(Roles.getAccess())).collect(Collectors.toList());
	}
}