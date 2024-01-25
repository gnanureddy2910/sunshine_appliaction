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
public class MyGroups {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupId;

	private String groupName;
	private boolean isActive = true;

	@ManyToMany(mappedBy = "assignGroups")
	private Set<Roles> roles;

	@ManyToMany
	@JoinTable(name = "group_Permission", joinColumns = @JoinColumn(name = "groupId"), inverseJoinColumns = @JoinColumn(name = "permissionId"))
	private Set<Permissions> assignPermissions;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MyGroups myGroups = (MyGroups) o;
		return groupId == myGroups.groupId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupId);
	}
}