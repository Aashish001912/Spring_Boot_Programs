package com.aashish.Repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.aashish.entity.Actor;
public interface IRepositoryActor extends CrudRepository<Actor,Integer>,PagingAndSortingRepository<Actor,Integer>{

}
