package com.dl.entity;

//import java.time.LocalDateTime;
import java.util.List;

//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Activitys {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityId;
	private String activityName;
	private boolean isActive = true;

	@OneToMany(targetEntity = Attributes.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "activity_Id", referencedColumnName = "activityId")
	private List<Attributes> attributes;

}
