package com.fbs.webapp.service;

import javax.validation.constraints.Email;
//import com.fbs.webapp.validation.ValidPassword;

public class UsersDto {

  /* ===== Declare Variables ===== */
  private String firstName;
  private String lastName;

  @Email
  private String emailAddress;

  // @ValidPassword - Password Validation Function Not Yet Working.
  private String password;

  /* ===== Constructors ===== */
  public UsersDto(){

  }

  public UsersDto(String firstName, String lastName, String emailAddress, String password){
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.password = password;
  }

  /* ===== Setters and Getters ===== */
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  } 

  public String getLastName() {
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
}