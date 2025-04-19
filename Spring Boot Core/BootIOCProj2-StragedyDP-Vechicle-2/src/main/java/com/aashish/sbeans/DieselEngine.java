package com.aashish.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DieselEngine implements Engine {

	public DieselEngine()
	{
		System.out.println("DieselEngine::0-param constructro");
	}
	@Override
	public void start() 
	{
		System.out.println("DieselEngine start");
		
	}

	@Override
	public void stop() {
		System.out.println("DieselEngine stop");
		
	}

}
