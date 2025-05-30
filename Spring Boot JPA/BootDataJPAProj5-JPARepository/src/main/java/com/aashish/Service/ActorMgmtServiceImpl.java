package com.aashish.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aashish.Repository.IRepositoryActor;
import com.aashish.entity.Actor;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IRepositoryActor actorRepo;

	@Override
	public String removeActorByIds(Iterable<Integer> ids) {
		List<Actor>list=actorRepo.findAllById(ids);
	    long count=list.size();
		//long count = StreamSupport.stream(list.spliterator(), true).count();
		if(count!=0) {
			//delete the records by ids in batch
			actorRepo.deleteAllByIdInBatch(ids);
		return count+" no of records are found and deleted";
		}
		return "No record found for deletion";
	}

	@Override
	public String removeAllActorInBatch() {
		long count=actorRepo.count();
		actorRepo.deleteAllInBatch();
		return count+" no of record are delete in batch processiing";
	}

	@Override
	public List<Actor> showActorByData(Actor actor, boolean ascOrder, String... props) {
		//prepare sort property
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
		//Example object
		Example<Actor>example=Example.of(actor);
		//use repo
		return actorRepo.findAll(example,sort);
	}

	@Override
	public Actor showActorById(int id) {
		
		return actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
	}

	


	
}
