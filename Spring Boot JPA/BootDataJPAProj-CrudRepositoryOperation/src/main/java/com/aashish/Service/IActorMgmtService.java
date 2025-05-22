package com.aashish.Service;

import java.util.List;

import com.aashish.entity.Actor;

public interface IActorMgmtService {
    public String registorActor(Actor actor);
    public long showActorCount();
    public String checkActorAvailibilty(int id);
    public String registerActors(Iterable<Actor> entities);
    public Iterable<Actor> showAllActor();
    public Iterable<Actor> showActorByIds(Iterable<Integer>ids); 
    public String showActorById(int id);
    public Actor fetchActorById(int id);
    public Actor getActorById(int id);
}
