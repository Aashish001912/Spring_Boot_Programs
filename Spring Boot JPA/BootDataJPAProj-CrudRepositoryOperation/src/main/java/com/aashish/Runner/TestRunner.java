package com.aashish.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aashish.Repository.IRepositoryActor;
import com.aashish.Service.ActorMgmtServiceImpl;
import com.aashish.Service.IActorMgmtService;
import com.aashish.entity.Actor;

@Component
public class TestRunner implements CommandLineRunner {

	
	 private final IRepositoryActor IActorRepository;

	    private final ActorMgmtServiceImpl actoService;
	@Autowired
	private IActorMgmtService actorService;
	
	TestRunner(ActorMgmtServiceImpl actoService, IRepositoryActor IActorRepository) {
        this.actoService = actoService;
        this.IActorRepository = IActorRepository;
    }
	@Override
	public void run(String... args) throws Exception{
		/*
		 try {
		 
			//prepare entity objects
			Actor actor=new Actor();
			actor.setAname("kalua");
			actor.setCategory("Comidean");
			actor.setAddrs("jaunpur");
			actor.setContactNo(48389l);
			actor.setFee(5693232.0);
			
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
		
		
		try {
			 String checkActorAvailibilty = actorService.checkActorAvailibilty(1);
		     System.out.println(checkActorAvailibilty);	
		}
		catch (Exception e) {
		e.printStackTrace();	
		}
		
		
		try {
			Actor  actor1=new  Actor(121, "rajesh1", "hyd", "HERO", 999999888L, 90000.0);
			Actor  actor2=new  Actor(122,"karan1", "delhi", "Villian", 193999888L, 40000.0);
			Actor  actor3=new  Actor(123,"suresh1", "mumbai", "Hero", 191991888L, 60000.0);
		    List<Actor>list=List.of(actor1,actor2,actor3);
		    String msg = actoService.registerActors(list);
		     System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
