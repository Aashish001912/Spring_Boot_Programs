package com.aashish;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.aashish.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProj1SeasonFinderAppApplication {

	@Bean(name="Id")
	public LocalDate createDate() {
		return LocalDate.now();
	}
	public static void main(String[] args) {
	//Create IOC Container
	ApplicationContext ctx=	SpringApplication.run(BootIocProj1SeasonFinderAppApplication.class, args);
	//get target Spring bean class Obj
	SeasonFinder finder=ctx.getBean("sf",SeasonFinder.class);
	//invoke business method
	String seasonName=finder.findSeason();
	System.out.println("Seanson Name:"+seasonName);
	((ConfigurableApplicationContext)ctx).close();
	
	}

}
