package com.fbs.webapp.entities;

import javax.persistence.*;

@Entity
@Table
public class Roles {

  /* ===== Set and Auto Incriment ID ===== */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  /* ===== Declare Variables ===== */
  private Integer id;
  private String access;

  /* ===== Constructors ===== */
  public Roles(){

  }
  
  public Roles(String access){
    this.access=access;
  }

  /* ===== Setters and Getters ===== */
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  } 
  public String getAccess() {
    return access;
  }
  public void setAccess(String access) {
    this.access = access;
  } 
}