package com.dl.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String storeName;
	private String latitude;
	private String longitude;
	private String storeCategory;
	private int pincode;
	private boolean isActive = true;

	@ManyToMany(mappedBy = "assignStores")
	private List<Users> users;

	@OneToMany(mappedBy = "storeId", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<StoreAttributeDetails> storeAttributeDetails;

	@OneToMany(mappedBy = "storeId", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Visit> visits;
}
