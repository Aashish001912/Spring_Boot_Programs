package com.aashish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashish.entity.Actor;
import com.aashish.repository.IActorReposotory;

@Service("actorService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	
    @Autowired
	private IActorReposotory actorRepo;
    
	@Override
	public String registerActro(Actor actor) {
		
		//save the object(record insertion)
		Actor saveActor=actorRepo.save(actor);
		
		return saveActor.getAid()+"is saved with the id value";
	}

}
