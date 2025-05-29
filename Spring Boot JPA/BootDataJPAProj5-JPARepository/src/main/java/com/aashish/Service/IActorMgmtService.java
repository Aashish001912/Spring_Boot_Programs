package com.aashish.Service;

import java.util.List;

import com.aashish.entity.Actor;

public interface IActorMgmtService {
    public String removeActorByIds(Iterable<Integer> ids);
    public String removeAllActorInBatch();
}
