package com.fbs.webapp.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.Collection;
import java.util.List;

@Entity
/* ===== Set Unique Constraint for Email Address Login ===== */
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "emailAddress"))
public class Users {
  
  /* ===== Set and Auto Incriment ID ===== */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  /* ===== Declare Variables ===== */
  private Integer id;
  private String firstName;
  private String lastName;
  @Email
  private String emailAddress;
  private String password;
  /* ===== Create a New Table Joining Users and Roles ===== */
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name="user_role",
    joinColumns = @JoinColumn
      (name = "idUser", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn
      (name = "idRole", referencedColumnName = "id"))
  private Collection<Roles> role;

  /* ===== Constructors ===== */
  public Users(){

  }

  public Users(String firstName, String lastName, String emailAddress, String password, List<Roles> role){
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.password = password;
    this.role = role;
  }

  /* ===== Setters and Getters ===== */
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  } 

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  } 

  public String getlastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  } 

  public String getEmailAddress() {
    return emailAddress;
  }
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  } 

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  } 

	public Collection<Roles> getRole() {
		return role;
	}
	public void setRole(Collection<Roles> role) {
		this.role = role;
	}
}