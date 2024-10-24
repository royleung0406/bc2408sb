package com.bootcamp2408.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
// JPA library/ Framework
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Addresses")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @Builder.Default
    @Setter
    private List<GeoEntity> geoEntity = new ArrayList<>();


  
    @Builder.Default
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List <PostEntity> posts = new ArrayList<>();
}