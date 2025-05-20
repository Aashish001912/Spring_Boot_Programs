package com.aashish.Service;

import java.util.ArrayList;
import java.util.List;

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
		return savedActor.getAid()+" id is saved in the table..";
	}
	
	@Override
	public long showActorCount() {
		return  actorRepo.count();
	}

	@Override
	public String checkActorAvailibilty(int id) {
		
		boolean existsById = actorRepo.existsById(id);
		return  existsById?"Actor Available":"Actor is not Available";
	}

	@Override
	public String registerActors(Iterable<Actor> entities) {
		//use repo
		Iterable<Actor>savedEntities=actorRepo.saveAll(entities);
		//get ids of the saved Entities
		int count=0;
		List<Integer>ids=new ArrayList();
		for(Actor entity:savedEntities) {
			count++;
			ids.add(entity.getAid());
		}
		return count+"no.of entities are saved with  id values ::\"+ids";
	}
	

}
