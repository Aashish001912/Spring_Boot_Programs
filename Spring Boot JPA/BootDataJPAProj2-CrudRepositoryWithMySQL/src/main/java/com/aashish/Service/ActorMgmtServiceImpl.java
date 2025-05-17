package com.aashish.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashish.Repository.IRepositoryActor;
import com.aashish.entity.Actor;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IRepositoryActor actorRepo;
	
	@Override
	public String registorActor(Actor actor) {
		Actor savedActor=actorRepo.save(actor);
		
		return savedActor.getAid()+" id added sucessfully... ";
	}

}
