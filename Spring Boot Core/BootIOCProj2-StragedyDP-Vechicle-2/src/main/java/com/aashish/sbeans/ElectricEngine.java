package com.aashish.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngine")
public class ElectricEngine implements Engine {

	public ElectricEngine()
	{
		System.out.println("ElectricEngine::0-param constructro");
	}
	@Override
	public void start()
	{
	System.out.println("ElectricEngine start");
	}

	@Override
	public void stop() {
	System.out.println("ElectricEngine stop");

	}

}
