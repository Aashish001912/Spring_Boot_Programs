package com.aashish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JPA_ACTOR_INFO")
@Data
public class Actor {
	@Column(name="AID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE  
	private Integer aid;
	
	@Column(name="ANAME",length=30)
	private String aname;
	
	@Column(name="ADDRS",length=30)
	private String addrs;
	
	@Column(name="CATEGORY",length=30)
	private String category;
	
	@Column(name="CONTACT_NO")
	private Long contactNo;
	
	@Column(name="FEE")
	private Double fee;
	

}
