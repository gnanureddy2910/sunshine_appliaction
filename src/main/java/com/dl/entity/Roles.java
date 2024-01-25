package com.dl.entity;

import java.util.Objects;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	private String roleName;
	private boolean isActive = true;

	@ManyToMany(mappedBy = "assignRoles")
	private Set<Users> users;

	@ManyToMany
	@JoinTable(name = "role_group", joinColumns = @JoinColumn(name = "roleId"), inverseJoinColumns = @JoinColumn(name = "groupId"))
	private Set<MyGroups> assignGroups;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Roles roles = (Roles) o;
		return roleId == roles.roleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId);
	}

}
