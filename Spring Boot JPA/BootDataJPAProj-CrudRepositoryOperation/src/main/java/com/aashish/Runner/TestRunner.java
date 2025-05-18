package com.aashish.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aashish.Service.IActorMgmtService;
import com.aashish.entity.Actor;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IActorMgmtService actorService;
	
	@Override
	public void run(String... args) throws Exception{
		/*
		 try {
		 
			//prepare entity objects
			Actor actor=new Actor();
			actor.setAname("Ranveer");
			actor.setCategory("Villan");
			actor.setAddrs("HYD");
			actor.setContactNo(56789l);
			actor.setFee(987687.0);
			
			//invoke b.method
			String msg=actorService.registorActor(actor);
			System.out.println(msg);
		}
        catch (Exception e) {
			// TODO: handle exception
		}
		*/
		
		try {
			
			 long showActorCount = actorService.showActorCount();
		     System.out.println("Actor Count: "+showActorCount);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
