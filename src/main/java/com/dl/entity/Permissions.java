package com.dl.entity;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permissions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permissionId;
	private String permissionName;
	private boolean isActive = true;

	@ManyToMany(mappedBy = "assignPermissions")
	private Set<MyGroups> groups;

}
