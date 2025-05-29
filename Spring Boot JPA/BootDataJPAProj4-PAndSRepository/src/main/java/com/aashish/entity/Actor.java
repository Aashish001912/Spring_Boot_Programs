package com.aashish.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="Actor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Actor {
  
	@Column(name="AID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer aid;
	
	@Column(name="ANAME",length = 30)
	@NonNull
	private   String  aname;
	
	
	@Column(name="ADDRS",length = 30)
	@NonNull
	private   String  addrs;
	
	@Column(name="CATEGORY",length = 30)
	@NonNull
	private   String category;
	
	
	@Column(name="CONTACT_NO")
	@NonNull
	private   Long  contactNo;
	
	@Column(name="FEE")
	@NonNull
	private   Double  fee;
	
}
