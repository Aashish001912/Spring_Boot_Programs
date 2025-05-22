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
		/*
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
		
		*/
		/*
		try {
			Actor  actor1=new  Actor("raj", "hyd", "HERO", 9999998L, 930000.0);
			Actor  actor2=new  Actor("kalu", "delhi", "Villian", 3999888L, 440000.0);
			Actor  actor3=new  Actor("surem", "mumbai", "Hero", 1991888L, 604000.0);
			
		    List<Actor>list=List.of(actor1,actor2,actor3);
		    String msg = actoService.registerActors(list);
		     System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    
	     */
		/*
		try {
			Iterable<Actor>list=actorService.showAllActor();
			list.forEach(actor->{
				
			System.out.println(actor);});
			System.out.println("================");
			list.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try {
			Iterable<Actor>list=actorService.showActorByIds(List.of(1,2,52));
		     list.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try {
			String msg=actorService.showActorById(1);
			System.out.println(msg);
		}
		catch (Exception e) {
		}
		*/
		/*
		try {
			Actor msg=actorService.fetchActorById(52);
			System.out.println(msg);
		}
		catch (Exception e) {
         e.printStackTrace(); 
		}
		*/
		try {
			Actor actorById = actorService.getActorById(9);
			System.out.println(actorById);
			
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}

}
