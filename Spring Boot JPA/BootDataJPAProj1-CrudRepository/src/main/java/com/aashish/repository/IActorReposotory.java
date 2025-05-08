package com.aashish.repository;

import org.springframework.data.repository.CrudRepository;

import com.aashish.entity.Actor;

public interface IActorReposotory extends CrudRepository<Actor, Integer> {
  
}
