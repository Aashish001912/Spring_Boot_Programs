package com.aashish.Service;

import java.util.List;

import com.aashish.entity.Actor;

public interface IActorMgmtService {
    public String removeActorByIds(Iterable<Integer> ids);
    public String removeAllActorInBatch();
    public List<Actor> showActorByData(Actor actor,boolean acsOrder,String ...props);
    public Actor showActorById(int id);
    public Actor fetchActorById(int id);
}
