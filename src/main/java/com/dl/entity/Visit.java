package com.dl.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitId;

    private String comment;
    private String status;
    private boolean isProcessed = false;

    @ManyToOne
    @JoinColumn(name = "storeId")
    @JsonBackReference
    private Stores storeId;

    @OneToMany(mappedBy = "visitId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StoreAttributeDetails> storeAttributeDetailsList;

   
}
