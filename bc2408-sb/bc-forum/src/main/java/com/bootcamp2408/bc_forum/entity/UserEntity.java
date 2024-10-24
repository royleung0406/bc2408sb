package com.bootcamp2408.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
// JPA library/ Framework
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private Integer user_id;
  private String name;
  private String username;
  private String phone;
  private String website;
  @Column(name = "address_street")
  private String addrStreet;
  @Column(name = "address_suite")
  private String addrSuite;
  @Column(name = "address_city")
  private String addrCity;
  @Column(name = "address_zip_code")
  private String addrZipcode;
  @Column(name = "address_lat")
  private String addrLat;
  @Column(name = "address_long")
  private String addrLng;
  @Column(name = "company_name")
  private String comName;
  @Column(name = "company_catch_phrase")
  private String comCatchPhrase;
  @Column(name = "company_bs")
  private String comBs;


  
    @Builder.Default
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List <PostEntity> posts = new ArrayList<>();
}