/*
package com.fbs.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
//import com.fbs.webapp.entities.Workshops;

@Repository
public interface WorkshopRepository //extends JpaRepository<Workshops, Integer>
  {
 
  // ##### Work in Progress #####
  // ##### Server Side input Validation - Search by Month #####

  public List<Workshops> finalAll(String monthSelect);

  Workshops findByMonth(String monthSelect);

  // ===== Sort Predefined Queries by Month ===== 
  // Learned from https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods - Listed in References in the Techinal Report
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?January%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?Febuary%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?March%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?April%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?May%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?June%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?July%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?August%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?September%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?October%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?November%"),
  @Query("SELECT daySelect, monthSelect, grade, price FROM workshop WHERE monthSelect LIKE %?December%"),
   
}
*/ 