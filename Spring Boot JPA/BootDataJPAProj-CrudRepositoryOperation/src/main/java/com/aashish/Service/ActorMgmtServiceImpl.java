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


	/*
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
	*/
	
	@Override
	public String registerActors(Iterable<Actor> entities) {
		//use repo
		Iterable<Actor>savedEntities=actorRepo.saveAll(entities);
		
		//get ids of the saved entities
		List<Integer> ids = StreamSupport.stream(savedEntities.spliterator(),false).map(Actor::getAid).collect(Collectors.toList());
		return ids.size()+" no of objects are saved  having id values ::"+ids;
	}

	@Override
	public Iterable<Actor> showAllActor() {
		
		return actorRepo.findAll();
	}

	@Override
	public Iterable<Actor> showActorByIds(Iterable<Integer> ids) {
		
		return actorRepo.findAllById(ids);
	}

	@Override
	public String showActorById(int id) {
		Optional<Actor>opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			Actor actor=opt.get();
			return "Actor Deatils::"+actor;
		}
		else {
			return id+" Actor is not found";
			}
	}

	@Override
	public Actor fetchActorById(int id) {
		Optional<Actor>opt=actorRepo.findById(id);
		if(opt.isEmpty())
		throw new IllegalArgumentException("Invalid Id");
		else
		return opt.get();
	}

	@Override
	public Actor getActorById(int id) {
		Actor actor=actorRepo.findById(id).orElse(new Actor("Duplicate actor","hyd","stuntman",5678l, 456.0));
		return actor;
	}
	

}
