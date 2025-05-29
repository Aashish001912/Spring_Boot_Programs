package com.aashish.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.aashish.entity.Actor;
public interface IRepositoryActor extends JpaRepository<Actor,Integer>{

}
