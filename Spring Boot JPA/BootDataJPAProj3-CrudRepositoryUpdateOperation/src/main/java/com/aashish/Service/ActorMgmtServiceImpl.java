package com.aashish.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashish.Repository.IRepositoryActor;
import com.aashish.entity.Actor;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IRepositoryActor actorRepo;

	@Override
	public String updateActorFeeById(int id, float hikePercentage) {
		Optional<Actor>opt=actorRepo.findById(id);
		if(opt.isEmpty())
			return id+" id is not found";
		else {
			//get Entity object for optional API
			Actor actor=opt.get();
			//hike the fee
			actor.setFee(actor.getFee()+(actor.getFee()*hikePercentage/100.0));
			actorRepo.save(actor);
			return id+" id actor is update with new fees";
		}
	
	}

	@Override
	public String updateActor(Actor actor) {
		actorRepo.save(actor);
		return "Actor Object is saved/updated";
	}

	@Override
	public String deleteById(int id) {
		Optional<Actor>opt=actorRepo.findById(id);
		if(opt.isEmpty())
			return id+" is is not found for deletion";
		else {
			actorRepo.deleteById(id);
		}
		return id+" is deleted"  ;
	}

	@Override
	public String deleteActor(Actor actor) {
		Optional<Actor>opt=actorRepo.findById(actor.getAid());
		if(opt.isEmpty())
			return actor.getAid()+" is is not found for deletion";
		else {
			actorRepo.delete(actor);
		}
		return actor.getAid()+" found and is deleted"  ;
	}
	


	
}
