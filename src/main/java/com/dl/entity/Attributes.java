package com.dl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attributes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attributeId;
	private String attributeName;
	private boolean isActive = true;

	public Attributes(String attributeId) {
		this.attributeId = Integer.parseInt(attributeId);
	}
}
