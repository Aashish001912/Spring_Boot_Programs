package com.aashish.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.aashish.Repository.IRepositoryActor;
import com.aashish.entity.Actor;



@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IRepositoryActor actorRepo;

	@Override
	public Iterable<Actor> showActorSorted(boolean ascOrder,String ...props) {
	    //create sort object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
		//use repo	
		Iterable<Actor>list=actorRepo.findAll(sort);
		return null;
	}
	



	

}
