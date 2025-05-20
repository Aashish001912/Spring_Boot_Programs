package com.aashish.Service;

import com.aashish.entity.Actor;

public interface IActorMgmtService {
    public String registorActor(Actor actor);
    public long showActorCount();
    public String checkActorAvailibilty(int id);
    public String registerActors(Iterable<Actor> entities);
    
}
