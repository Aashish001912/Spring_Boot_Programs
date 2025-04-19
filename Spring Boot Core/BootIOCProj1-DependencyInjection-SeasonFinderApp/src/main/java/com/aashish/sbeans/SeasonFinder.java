package com.aashish.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder
{
  @Autowired
  private LocalDate ldt;
  
 public String findSeason()
 {
	  //business method
	  int month=ldt.getMonthValue();
	  if(month>=3&& month<=6)
	   return "Summer Season";
	  else if(month>=7&&month<=10)
		  return "Rainey Season";
	  else
		  return "Winter Season";
		
 }
}
