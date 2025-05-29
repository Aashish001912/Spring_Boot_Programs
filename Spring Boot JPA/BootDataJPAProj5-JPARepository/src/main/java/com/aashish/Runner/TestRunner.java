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
		String msg=actorService.removeActorByIds(List.of(102,202));
		System.out.println(msg);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		*/
		
		try {
			String msg=actorService.removeAllActorInBatch();
			System.out.println(msg);
		}
		catch (Exception e) {
		   e.printStackTrace();
		}
	}

}
