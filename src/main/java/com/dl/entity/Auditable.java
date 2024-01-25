package com.dl.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners (AuditingEntityListener.class)
public class Auditable {
	
	@CreatedBy
	protected String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private LocalDateTime createdAt;
	
	@LastModifiedBy
	protected String lastModifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private LocalDateTime updatedAt;

}
