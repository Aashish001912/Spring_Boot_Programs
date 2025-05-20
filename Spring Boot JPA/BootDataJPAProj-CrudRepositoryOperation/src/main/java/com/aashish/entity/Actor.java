package com.aashish.entity;


import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="Actor")
@Data
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Actor {
  
	@Column(name="AID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer aid;
	
	@Column(name="ANAME",length = 30)
	private   String  aname;
	@NonNull
	
	@Column(name="ADDRS",length = 30)
	private   String  addrs;
	@NonNull
	
	@Column(name="CATEGORY",length = 30)
	private   String category;
	@NonNull
	
	@Column(name="CONTACT_NO")
	private   Long  contactNo;
	@NonNull
	
	@Column(name="FEE")
	private   Double  fee;
	
}
