package com.aashish.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aashish.entity.Actor;
import com.aashish.service.IActorMgmtService;

@Component
public class CrudRespositoryTestRunner implements CommandLineRunner {
    
	@Autowired
	private IActorMgmtService actorService;
	
    @Override
	public void run(String... args) throws Exception {
	  try {
		  //perpare entity object
		   Actor actor=new Actor();
		   actor.setAname("rahul");
		   actor.setCategory("hero");
		   actor.setContactNo(987654l);
		   actor.setAddrs("Hyd");
		   actor.setFee(9876.0);
		   
		   //invoke the service method
		   String msg=actorService.registerActro(actor);
		   System.out.println(msg);
	  }
	  catch (Exception e) {
       e.printStackTrace();
	  }
	}

}
