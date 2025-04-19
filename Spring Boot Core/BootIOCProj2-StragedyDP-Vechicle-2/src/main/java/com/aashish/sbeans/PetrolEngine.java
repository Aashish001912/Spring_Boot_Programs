package com.aashish.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngine")
public class PetrolEngine implements Engine {

	public PetrolEngine()
	{
		System.out.println("PetrolEngine::0-param constructro");
	}
	@Override
	public void start() 
	{
		System.out.println("PetrolEngine start");
	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine stop");
	}

}
