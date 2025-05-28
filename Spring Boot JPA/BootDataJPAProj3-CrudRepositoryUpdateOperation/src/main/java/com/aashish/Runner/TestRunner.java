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
			String msg=actorService.updateActorFeeById(1, 10);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try {
			Actor actor=new Actor(52,"Aashish","Delhi","super star",987654l,45678.0);
			String msg=actorService.updateActor(actor);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try {
			String msg=actorService.deleteById(353);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try {
			Actor actor=new Actor(1,"raja","hyd","hero",98765L,3456.0);
			String msg=actorService.deleteActor(actor);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		try {
			String msg=actorService.deleteActorById(List.of(52,1,153));
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
