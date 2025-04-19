package com.aashish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.aashish.sbeans.Vehicle;

@SpringBootApplication
public class BootIocProj2VechicleSdp2Application 
{
	public static void main(String[] args) 
	{
	ApplicationContext ctx=	SpringApplication.run(BootIocProj2VechicleSdp2Application.class, args);
    Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
    vehicle.journey("hyd", "delhi");
    ((ConfigurableApplicationContext)ctx).close();
	}

}
