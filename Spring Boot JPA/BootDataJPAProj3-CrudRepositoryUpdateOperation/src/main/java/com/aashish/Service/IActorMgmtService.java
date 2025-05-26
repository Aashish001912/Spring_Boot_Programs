package com.aashish.Service;

import java.util.List;

import com.aashish.entity.Actor;

public interface IActorMgmtService {
    public String updateActorFeeById(int id,float hikePercentage);
    public String updateActor (Actor actor);
    public String deleteById(int id);
    public String deleteActor(Actor actor);
}
